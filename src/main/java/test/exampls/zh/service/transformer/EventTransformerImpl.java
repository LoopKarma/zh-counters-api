package test.exampls.zh.service.transformer;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import test.exampls.zh.dto.CounterDTO;
import test.exampls.zh.domain.Event;
import test.exampls.zh.domain.EventType;

@Service
public class EventTransformerImpl implements EventTransformer {
    private final Gson gson = new Gson();

    public Event toEvent(CounterDTO counter) {

        return Event.builder()
                .type(EventType.COUNTER_UPDATED)
                .payload(gson.toJson(counter))
                .build();
    }
}
