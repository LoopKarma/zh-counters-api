package test.exampls.zenhomes.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import test.exampls.zenhomes.api.dto.CounterDTO;
import test.exampls.zenhomes.api.dto.CounterUpdateDTO;
import test.exampls.zenhomes.domain.Counter;
import test.exampls.zenhomes.domain.Village;
import test.exampls.zenhomes.exception.NotFoundException;
import test.exampls.zenhomes.repository.CounterRepository;
import test.exampls.zenhomes.repository.VillageRepository;

import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterRepository counterRepository;
    private final VillageRepository villageRepository;

    @Override
    public void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId).orElseThrow(NotFoundException::new);

        BeanUtils.copyProperties(updateDTO, counter);
        log.info("Counter with id={} is updated", counterId);

        counterRepository.saveAndFlush(counter);
    }

    @Override
    public CounterDTO getCounter(Integer counterId) throws NotFoundException {
        Counter counter = counterRepository.findById(counterId)
                .orElseThrow(createNotFoundException(counterId, "Counter"));

        Village village = villageRepository.findById(counter.getVillageId())
                .orElseThrow(createNotFoundException(counter.getVillageId(), "Village"));

        return new CounterDTO(counter.getId(), village.getName());
    }

    private Supplier<NotFoundException> createNotFoundException(Integer id, String entity) {
        return () -> new NotFoundException(String.format("%s with id %d is not found", entity, id));
    }
}
