package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class ContactEntity {

    private Long id;

    private String phoneNumber;

    private String email;

    private String profileLink;
}
