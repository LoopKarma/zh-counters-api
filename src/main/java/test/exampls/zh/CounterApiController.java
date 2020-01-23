package test.exampls.zh;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.exampls.zh.api.CounterApi;
import test.exampls.zh.dto.CounterDTO;
import test.exampls.zh.dto.CounterUpdateDTO;
import test.exampls.zh.service.CounterService;

@RestController
@RequestMapping({"", "/v1"})
@RequiredArgsConstructor
public class CounterApiController implements CounterApi {
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
