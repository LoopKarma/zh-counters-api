package test.exampls.zenhomes.service.transformer;

import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.domain.Event;

public interface EventTransformer {
    Event toEvent(CounterDTO counter);
}
