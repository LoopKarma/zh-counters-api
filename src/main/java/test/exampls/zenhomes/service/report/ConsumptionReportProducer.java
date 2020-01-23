package test.exampls.zenhomes.service.report;

import test.exampls.zenhomes.dto.ConsumptionReportDTO;
import test.exampls.zenhomes.dto.ReportContextDTO;

public interface ConsumptionReportProducer {
    ConsumptionReportDTO createReport(ReportContextDTO contextDTO);
}
