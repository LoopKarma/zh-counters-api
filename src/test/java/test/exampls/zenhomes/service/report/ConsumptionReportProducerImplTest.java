package test.exampls.zenhomes.service.report;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.Village;
import test.exampls.zenhomes.dto.ConsumptionReportDTO;
import test.exampls.zenhomes.dto.ReportContextDTO;
import test.exampls.zenhomes.repository.EventRepository;
import test.exampls.zenhomes.repository.VillageRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static test.exampls.zenhomes.domain.EventType.COUNTER_UPDATED;

@ExtendWith(MockitoExtension.class)
class ConsumptionReportProducerImplTest {
    @Mock
    EventRepository eventRepository;
    @Mock
    VillageRepository villageRepository;

    @InjectMocks
    ConsumptionReportProducerImpl consumptionReportProducer;

    private Gson gson = new Gson();

    @Test
    void createReport() {
        //given
        Date dateFrom = new Date();
        Date dateTo = new Date();
        ReportContextDTO contextDTO = getReportContextDTO(dateFrom, dateTo);

        Village village1 = new Village(1, "test1");
        Village village2 = new Village(2, "test2");
        List<Village> villageList = List.of(
                village1,
                village2
        );

        List<Event> events = List.of(
                buildEvent("{\"id\":1,\"amount\":1230.0, \"villageId\":1}"),
                buildEvent("{\"id\":1,\"amount\":1231.5, \"villageId\":1}"),
                buildEvent("{\"id\":2,\"amount\":5030.0, \"villageId\":1}"),
                buildEvent("{\"id\":2,\"amount\":5031.0, \"villageId\":1}"),
                buildEvent("{\"id\":2,\"amount\":5032.0, \"villageId\":1}"),
                buildEvent("{\"id\":2,\"amount\":5036.0, \"villageId\":1}"),
                buildEvent("{\"id\":3,\"amount\":1.0, \"villageId\":2}"),
                buildEvent("{\"id\":3,\"amount\":1.1, \"villageId\":2}")
        );
        //when
        when(eventRepository.findAllByTypeAndCreatedOnBetweenOrderByCreatedOnAsc(COUNTER_UPDATED, dateFrom, dateTo))
                .thenReturn(events);
        when(villageRepository.findAllById(Set.of(1,2))).thenReturn(villageList);
        ConsumptionReportDTO report = consumptionReportProducer.createReport(contextDTO);

        //then
        assertEquals(2, report.getVillages().size());
        assertEquals(1, (int) report.getVillages().get(0).getVillage().getId());
        assertEquals(7.5F, (float) report.getVillages().get(0).getConsumption(), 0.00001);
        assertEquals(2, (int) report.getVillages().get(1).getVillage().getId());
        assertEquals(0.1F, (float) report.getVillages().get(1).getConsumption(), 0.00001);
    }

    private ReportContextDTO getReportContextDTO(Date dateFrom, Date dateTo) {
        return ReportContextDTO.builder()
                    .fromDate(dateFrom)
                    .toDate(dateTo)
                    .build();
    }

    private Event buildEvent(String s) {
        return Event.builder()
                .payload(s)
                .type(COUNTER_UPDATED)
                .build();
    }
}
