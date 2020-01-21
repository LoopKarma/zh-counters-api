package test.exampls.zenhomes.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterDTO {
    private Integer id;
    private String villageName;
}
