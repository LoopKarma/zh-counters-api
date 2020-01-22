package test.exampls.zenhomes.service.eventprocessor;

import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventType;
import test.exampls.zenhomes.exception.EventProcessingException;

public interface EventProcessor {
    EventType getSupportedType();
    void doProcess(Event event) throws EventProcessingException;
}
