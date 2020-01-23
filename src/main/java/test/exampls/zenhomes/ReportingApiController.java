package test.exampls.zenhomes;

import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.exampls.zenhomes.api.ReportingApi;
import test.exampls.zenhomes.dto.ConsumptionReportDTO;
import test.exampls.zenhomes.dto.ReportContextDTO;
import test.exampls.zenhomes.exception.DurationParsingException;
import test.exampls.zenhomes.service.report.ConsumptionReportProducer;
import test.exampls.zenhomes.util.DurationParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static java.util.Optional.of;

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
