package test.exampls.zenhomes.service.transformer;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class EventTransformerImplTest {
    private EventTransformerImpl eventTransformer = new EventTransformerImpl();
    private Gson gson = new Gson();

    @Test
    void toEvent() {
        Village village = new Village();
        village.setId(1);
        village.setName("TestName");
        CounterDTO counter = CounterDTO.builder().id(1).amount(123.1F).build();

        Event event = eventTransformer.toEvent(counter);

        assertEquals(EventType.COUNTER_UPDATED, event.getType());
        assertEquals(gson.toJson(counter), event.getPayload());
    }
}
