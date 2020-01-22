package test.exampls.zenhomes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import test.exampls.zenhomes.api.dto.CounterDTO;
import test.exampls.zenhomes.api.dto.CounterUpdateDTO;
import test.exampls.zenhomes.domain.Counter;
import test.exampls.zenhomes.domain.Event;
import test.exampls.zenhomes.exception.NotFoundException;
import test.exampls.zenhomes.repository.CounterRepository;
import test.exampls.zenhomes.service.transformer.EventTransformer;

import java.util.UUID;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;
    private final EventService eventService;
    private final EventTransformer eventTransformer;

    @Override
    public void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId).orElseThrow(NotFoundException::new);

        BeanUtils.copyProperties(updateDTO, counter);
        log.info("Counter({}) is updated", counterId);

        counterRepository.saveAndFlush(counter);

        createUpdateCounterEvent(counter);
    }

    @Override
    public CounterDTO getCounter(Integer counterId) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId)
                .orElseThrow(createNotFoundException(counterId, "Counter"));

        return new CounterDTO(
                counter.getId(),
                counter.getAmount(),
                counter.getVillage().getName()
        );
    }

    private void createUpdateCounterEvent(Counter counter) {
        CounterDTO counterDTO = new CounterDTO();
        BeanUtils.copyProperties(counter, counterDTO);

        Event event = eventTransformer.toEvent(counterDTO);
        UUID eventUuid = eventService.createEvent(event);
        log.info("Counter update event ({}) is created", eventUuid);
    }


    private Supplier<NotFoundException> createNotFoundException(Integer id, String entity) {
        return () -> new NotFoundException(String.format("%s with id %d is not found", entity, id));
    }
}
