package liga.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalDeviationDto {

    @Id
    private Long deviceId;

    private List<String> deviation;

}
