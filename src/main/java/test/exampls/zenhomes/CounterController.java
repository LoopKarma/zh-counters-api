package test.exampls.zenhomes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.exampls.zenhomes.api.CounterApi;
import test.exampls.zenhomes.api.dto.CounterDTO;
import test.exampls.zenhomes.api.dto.CounterUpdateDTO;
import test.exampls.zenhomes.service.CounterService;

@RestController
@RequestMapping({"", "/v1"})
@RequiredArgsConstructor
public class CounterController implements CounterApi {
    private final CounterService counterService;

    @Override
    public Integer update(Integer counterId, CounterUpdateDTO updateDTO) {
        counterService.updateCounter(counterId, updateDTO);

        return counterId;
    }

    @Override
    public CounterDTO get(Integer counterId) {
        return counterService.getCounter(counterId);
    }
}
