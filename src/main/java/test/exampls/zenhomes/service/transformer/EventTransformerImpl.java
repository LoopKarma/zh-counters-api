package test.exampls.zenhomes.service.transformer;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import test.exampls.zenhomes.api.dto.CounterDTO;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventType;

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
