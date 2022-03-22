package liga.medical.personservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private String firstName;

    private Long concatId;

    private Long countryId;

    @NotBlank
    private String phoneNumber;

    private String city;

    private Long index;

    private String street;

    private String building;

    private String flat;
}