package test.exampls.zh.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.exampls.zh.dto.ConsumptionReportDTO;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface ReportingApi {
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/consumption-report/{duration}"},
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    ConsumptionReportDTO update(@PathVariable("duration") String duration);

}
