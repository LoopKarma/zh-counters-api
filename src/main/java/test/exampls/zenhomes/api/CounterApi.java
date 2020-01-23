package test.exampls.zenhomes.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.dto.CounterUpdateDTO;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface CounterApi {
    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/counter/{counterId}"},
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    Integer update(@PathVariable("counterId") Integer counterId,
                      @RequestBody CounterUpdateDTO updateDTO);

    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/counter/{counterId}"},
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    CounterDTO get(@PathVariable("counterId") Integer counterId);
}
