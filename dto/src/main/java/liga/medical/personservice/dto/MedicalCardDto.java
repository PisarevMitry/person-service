package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardDto {

    @NotBlank
    private String clientStatus;

    @NotBlank
    private String medStatus;

    private LocalDate registryDt;

    private String comment;
}
