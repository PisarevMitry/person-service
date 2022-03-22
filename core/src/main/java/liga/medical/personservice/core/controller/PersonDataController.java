package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.dto.PersonDataDto;
import org.modelmapper.ModelMapper;
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
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/person-data")
public class PersonDataController {

    @Autowired
    private PersonDataRepository personDataRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewPersonData(@RequestBody @Valid PersonDataDto personDataDTO) {
        PersonDataEntity personDataEntity = modelMapper.map(personDataDTO, PersonDataEntity.class);
        personDataRepository.insert(personDataEntity);
    }

    @PostMapping("/save-all")
    void saveNewPersonData(@RequestBody @Valid List<PersonDataDto> personDataDTO) {
        List<PersonDataEntity> personDataEntityList = personDataDTO.stream().map(el -> modelMapper.map(el, PersonDataEntity.class)).collect(Collectors.toList());
        personDataRepository.insertAll(personDataEntityList);
    }

    @GetMapping("/{id}")
    PersonDataDto getPersonDataById(@PathVariable Long id) {
        PersonDataEntity personDataEntity = personDataRepository.findById(id);
        return modelMapper.map(personDataEntity, PersonDataDto.class);
    }

    @GetMapping("")
    List<PersonDataDto> getPersonDataByListId(@RequestParam List<Long> id) {
        List<PersonDataEntity> personDataEntity = personDataRepository.findByListId(id);
        return personDataEntity.stream().map(el -> modelMapper.map(el, PersonDataDto.class)).collect(Collectors.toList());
    }
}