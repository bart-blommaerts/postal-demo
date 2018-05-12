package be.bbconsulting.postal.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventChannel {

    String EVENT_OUT = "eventOut";

    @Output(EVENT_OUT)
    MessageChannel eventOut();
}

