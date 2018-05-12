package be.bbconsulting.postal.events;

import java.util.Map;

public class RoundsRequestedEvent extends Event {

    public RoundsRequestedEvent(Map<String, Object> data) {
        super(data);
    }
}
