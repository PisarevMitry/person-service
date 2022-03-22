package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class AddressEntity {

    private Long id;

    private Long contactId;

    private Long countryId;

    private String city;

    private Integer index;

    private String street;

    private String building;

    private String flat;

}
