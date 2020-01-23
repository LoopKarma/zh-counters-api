package test.exampls.zenhomes.service.report;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.exampls.zenhomes.domain.Village;
import test.exampls.zenhomes.dto.ConsumptionReportDTO.ConsumptionReportItemDTO;
import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.domain.EventType;
import test.exampls.zenhomes.dto.ReportContextDTO;
import test.exampls.zenhomes.dto.ConsumptionReportDTO;
import test.exampls.zenhomes.repository.EventRepository;
import test.exampls.zenhomes.repository.VillageRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
public class ConsumptionReportProducerImpl implements ConsumptionReportProducer {
    private final EventRepository eventRepository;
    private final VillageRepository villageRepository;
    private final Gson gson = new Gson();

    @Override
    public ConsumptionReportDTO createReport(ReportContextDTO contextDTO) {
        List<Event> orderedEvent = eventRepository.findAllByTypeAndCreatedOnBetweenOrderByCreatedOnAsc(
                EventType.COUNTER_UPDATED, contextDTO.getFromDate(), contextDTO.getToDate());

        Map<Integer, Map<Integer, Float>> villageToCounterToDiff = orderedEvent.stream()
                .map(e -> gson.fromJson(e.getPayload(), CounterDTO.class))
                .collect(groupingBy(CounterDTO::getVillageId,
                        groupingBy(CounterDTO::getId, teeing(
                                Collectors.maxBy(Comparator.comparing(CounterDTO::getAmount)),
                                Collectors.minBy(Comparator.comparing(CounterDTO::getAmount)),
                                (e1, e2) -> {
                                    if (e1.isPresent() && e2.isPresent()) {
                                        return e1.get().getAmount() - e2.get().getAmount();
                                    }
                                    return 0F;
                                }
                        ))));

        Set<Integer> iterable = villageToCounterToDiff.keySet();
        List<Village> villages = villageRepository.findAllById(iterable);
        Map<Integer, Village> villageMap = villages.stream().collect(toMap(Village::getId, Function.identity()));

        List<ConsumptionReportItemDTO> items = new ArrayList<>();
        for (Integer villageId : villageToCounterToDiff.keySet()) {
            Village village = villageMap.get(villageId);
            Map<Integer, Float> counterConsumptionDiff = villageToCounterToDiff.get(villageId);
            Float sum = counterConsumptionDiff.values().stream().reduce(0F, Float::sum);
            items.add(new ConsumptionReportItemDTO(village, sum));
        }

        return new ConsumptionReportDTO(items);
    }
}
