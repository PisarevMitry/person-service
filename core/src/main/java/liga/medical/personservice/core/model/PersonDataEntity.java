package liga.medical.personservice.core.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDataEntity {

    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDt;

    private Integer age;

    private Character sex;

    private Long contactId;

    private Long medicalCardId;

    private Long parentId;
}
