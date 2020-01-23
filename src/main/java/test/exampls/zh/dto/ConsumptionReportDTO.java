package test.exampls.zh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import test.exampls.zh.domain.Village;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumptionReportDTO {
    private List<ConsumptionReportItemDTO> villages;

    @Getter
    @AllArgsConstructor
    public static class ConsumptionReportItemDTO {
        private Village village;
        private Float consumption;
    }
}
