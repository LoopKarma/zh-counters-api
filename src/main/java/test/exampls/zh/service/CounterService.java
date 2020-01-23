package test.exampls.zh.service;

import test.exampls.zh.dto.CounterDTO;
import test.exampls.zh.dto.CounterUpdateDTO;
import test.exampls.zh.exception.NotFoundException;

public interface CounterService {
    void updateCounter(Integer counterId, CounterUpdateDTO updateDTO) throws NotFoundException;
    CounterDTO getCounter(Integer counterId) throws NotFoundException;
}
