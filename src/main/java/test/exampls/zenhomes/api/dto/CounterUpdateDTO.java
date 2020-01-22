package test.exampls.zenhomes.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CounterUpdateDTO {
    @NotNull
    private Float amount;
}
