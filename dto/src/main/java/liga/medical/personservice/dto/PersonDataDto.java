package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataDto {

    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private LocalDate birthDt;

    private Integer age;

    @NotBlank
    private Character sex;

    @NotBlank
    private Long contactId;

    @NotBlank
    private Long medicalCardId;

    private Long parentId;
}
