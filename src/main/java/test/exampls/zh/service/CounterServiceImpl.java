package test.exampls.zh.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import test.exampls.zh.dto.CounterDTO;
import test.exampls.zh.dto.CounterUpdateDTO;
import test.exampls.zh.domain.Counter;
import test.exampls.zh.domain.Event;
import test.exampls.zh.exception.NotFoundException;
import test.exampls.zh.repository.CounterRepository;
import test.exampls.zh.service.transformer.EventTransformer;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;
    private final EventService eventService;
    private final EventTransformer eventTransformer;

    @Override
    @Transactional
    public void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId).orElseThrow(NotFoundException::new);

        //save event before counter update to ensure we have old counter value
        createUpdateCounterEvent(counter);

        BeanUtils.copyProperties(updateDTO, counter);
        log.info("Counter({}) is updated", counterId);
        counterRepository.saveAndFlush(counter);

        //save event after counter update to keep new counter value
        createUpdateCounterEvent(counter);
    }

    @Override
    public CounterDTO getCounter(Integer counterId) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId)
                .orElseThrow(createNotFoundException(counterId, "Counter"));

        return CounterDTO.builder()
                .id(counter.getId())
                .amount(counter.getAmount())
                .villageName(counter.getVillage().getName())
                .build();
    }

    private void createUpdateCounterEvent(Counter counter) {
        CounterDTO counterDTO = new CounterDTO();
        BeanUtils.copyProperties(counter, counterDTO);

        Event event = eventTransformer.toEvent(counterDTO);
        Integer eventUuid = eventService.createEvent(event);
        log.info("Counter update event ({}) is created", eventUuid);
    }


    private Supplier<NotFoundException> createNotFoundException(Integer id, String entity) {
        return () -> new NotFoundException(String.format("%s with id %d is not found", entity, id));
    }
}
