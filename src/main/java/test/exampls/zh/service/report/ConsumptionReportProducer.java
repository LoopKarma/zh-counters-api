package test.exampls.zh.service.report;

import test.exampls.zh.dto.ConsumptionReportDTO;
import test.exampls.zh.dto.ReportContextDTO;

public interface ConsumptionReportProducer {
    ConsumptionReportDTO createReport(ReportContextDTO contextDTO);
}
