package test.exampls.zh.service.transformer;

import test.exampls.zh.dto.CounterDTO;
import test.exampls.zh.domain.Event;

public interface EventTransformer {
    Event toEvent(CounterDTO counter);
}
