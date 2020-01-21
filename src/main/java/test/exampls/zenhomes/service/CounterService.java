package test.exampls.zenhomes.service;

import test.exampls.zenhomes.api.dto.CounterDTO;
import test.exampls.zenhomes.api.dto.CounterUpdateDTO;
import test.exampls.zenhomes.exception.NotFoundException;

public interface CounterService {
    void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException;
    CounterDTO getCounter(Integer counterId) throws NotFoundException;
}
