package be.bbconsulting.postal.events;

import be.bbconsulting.postal.events.avro.AvroEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventProducer {

    private EventChannel eventChannel;

    public EventProducer(EventChannel eventChannel) {
        this.eventChannel = eventChannel;
    }

    public void publishEvent(Event event) {
        Message<AvroEvent> message = buildMessage(event);

        eventChannel.eventOut().send(message);
    }

    public Message<AvroEvent> buildMessage(Event event)  {
        AvroEvent avroEvent = map(event);

        return MessageBuilder.withPayload(avroEvent)
                .setHeader(MessageHeaders.CONTENT_TYPE, "avro/bytes")
                .setHeader("type", event.getName())
                .build();
    }

    public AvroEvent map(Event event) {
        Map<CharSequence, CharSequence> data = new HashMap<>();
        event.getData().forEach((k, v) -> data.put(k, v.toString()));

        return buildAvroEvent(event, data);
    }

    private AvroEvent buildAvroEvent(Event event, Map<CharSequence, CharSequence> data) {

        return AvroEvent.newBuilder()
                .setEventUUID(event.getEventUUID().toString())
                .setName(event.getName())
                .setData(data)
                .build();
    }
}