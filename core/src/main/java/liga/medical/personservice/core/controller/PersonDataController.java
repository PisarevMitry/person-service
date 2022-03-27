package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.dto.PersonDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/person-data")
public class PersonDataController {

    @Autowired
    private PersonDataService personDataService;

    @PostMapping("/save")
    void saveNewPersonData(@RequestBody @Valid PersonDataDto personDataDTO) {
        personDataService.insert(personDataDTO);
    }

    @PostMapping("/save-all")
    void saveNewPersonData(@RequestBody @Valid List<PersonDataDto> personDataListDTO) {
        personDataService.insertAll(personDataListDTO);
    }

    @GetMapping("/{id}")
    PersonDataDto getPersonDataById(@PathVariable Long id) {
        return personDataService.findById(id);
    }

    @GetMapping("")
    List<PersonDataDto> getPersonDataByListId(@RequestParam List<Long> id) {
        return personDataService.findByListId(id);
    }
}