package test.exampls.zenhomes.service.eventprocessor;

import org.springframework.stereotype.Service;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventType;
import test.exampls.zenhomes.exception.EventProcessingException;

@Service
public class CounterUpdateProcessor implements EventProcessor {
    @Override
    public void doProcess(Event event) throws EventProcessingException {

    }

    @Override
    public EventType getSupportedType() {
        return EventType.COUNTER_UPDATED;
    }
}
