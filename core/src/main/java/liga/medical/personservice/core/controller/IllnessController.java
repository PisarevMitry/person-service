package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.IllnessEntity;
import liga.medical.personservice.core.repository.IllnessRepository;
import liga.medical.personservice.dto.IllnessDto;
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
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessRepository illnessRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    void saveNewIllness(@RequestBody @Valid IllnessDto illnessDTO) {
        IllnessEntity illnessEntity = modelMapper.map(illnessDTO, IllnessEntity.class);
        illnessRepository.insert(illnessEntity);
    }

    @PostMapping("/save-all")
    void saveNewIllness(@RequestBody @Valid List<IllnessDto> illnessDTO) {
        List<IllnessEntity> illnessEntityList = illnessDTO.stream().map(el -> modelMapper.map(el, IllnessEntity.class)).collect(Collectors.toList());
        illnessRepository.insertAll(illnessEntityList);
    }

    @GetMapping("/{id}")
    IllnessDto getIllnessById(@PathVariable Long id) {
        IllnessEntity illnessEntity = illnessRepository.findById(id);
        return modelMapper.map(illnessEntity, IllnessDto.class);
    }

    @GetMapping("")
    List<IllnessDto> getIllnessByListId(@RequestParam List<Long> id) {
        List<IllnessEntity> illnessEntity = illnessRepository.findByListId(id);
        return illnessEntity.stream().map(el -> modelMapper.map(el, IllnessDto.class)).collect(Collectors.toList());
    }
}