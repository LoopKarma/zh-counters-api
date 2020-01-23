package test.exampls.zenhomes.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CounterDTO {
    private Integer id;
    private Float amount;
    private String villageName;
    private Integer villageId;
}
