package test.exampls.zenhomes.service;

import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.dto.CounterUpdateDTO;
import test.exampls.zenhomes.exception.NotFoundException;

public interface CounterService {
    void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException;
    CounterDTO getCounter(Integer counterId) throws NotFoundException;
}
