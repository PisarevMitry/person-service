package liga.medical.personservice.core.service;

import liga.medical.personservice.dto.PersonDataDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonDataService extends AbstractService<PersonDataDto>, UserDetailsService {
}
