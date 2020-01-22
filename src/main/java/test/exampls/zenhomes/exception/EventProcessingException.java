package test.exampls.zenhomes.exception;

import java.util.UUID;

public class EventProcessingException extends Exception {
    public EventProcessingException(UUID eventUuid, String reason) {
        super(String.format("Cannot process event(%s). Reason: '%s'",
                eventUuid.toString(), reason));
    }
}
