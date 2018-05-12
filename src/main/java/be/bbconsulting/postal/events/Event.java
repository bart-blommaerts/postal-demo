package be.bbconsulting.postal.events;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class Event {
    private final UUID eventUUID;
    private final String name;

    private final Map<String, Object> data;

    public Event(final Map<String, Object> data) {
        this.eventUUID = UUID.randomUUID();
        this.data = data.entrySet()
                .stream()
                .filter(e -> e.getKey() != null && e.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        this.name = getClass().getSimpleName();
    }

    public UUID getEventUUID() {
        return eventUUID;
    }

    public Map<String, Object> getData() {
        return Collections.unmodifiableMap(data);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventUUID=" + eventUUID +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}

