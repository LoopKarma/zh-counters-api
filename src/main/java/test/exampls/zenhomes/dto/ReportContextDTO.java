package test.exampls.zenhomes.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Getter
@Builder
public class ReportContextDTO {
    private Date fromDate;
    private Date toDate;
}
