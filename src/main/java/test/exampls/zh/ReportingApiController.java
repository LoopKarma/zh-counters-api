package test.exampls.zh;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.exampls.zh.api.ReportingApi;
import test.exampls.zh.dto.ConsumptionReportDTO;
import test.exampls.zh.dto.ReportContextDTO;
import test.exampls.zh.service.report.ConsumptionReportProducer;
import test.exampls.zh.util.DurationParser;

import java.util.Date;

@RestController
@RequestMapping({"", "/v1"})
@RequiredArgsConstructor
public class ReportingApiController implements ReportingApi {
    private final ConsumptionReportProducer consumptionReportProducer;

    @Override
    public ConsumptionReportDTO update(String duration) {
        ReportContextDTO contextDTO = ReportContextDTO.builder()
                .fromDate(DurationParser.parseDuration(duration))
                .toDate(new Date())
                .build();

        return consumptionReportProducer.createReport(contextDTO);
    }
}
