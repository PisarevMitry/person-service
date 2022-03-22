package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
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
@RequestMapping("/medical-card")
public class MedicalCardController {

    @Autowired
    private MedicalCardRepository medicalCardRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    void saveNewMedicalCard(@RequestBody @Valid MedicalCardDto medicalCardDTO) {
        MedicalCardEntity cardEntity = modelMapper.map(medicalCardDTO, MedicalCardEntity.class);
        medicalCardRepository.insert(cardEntity);
    }

    @PostMapping("/save-all")
    void saveNewMedicalCard(@RequestBody @Valid List<MedicalCardDto> medicalCard) {
        List<MedicalCardEntity> medicalCardEntityList = medicalCard.stream().map(el -> modelMapper.map(el, MedicalCardEntity.class)).collect(Collectors.toList());
        medicalCardRepository.insertAll(medicalCardEntityList);
    }

    @GetMapping("/{id}")
    MedicalCardDto getMedicalCardById(@PathVariable Long id) {
        MedicalCardEntity medicalCard = medicalCardRepository.findById(id);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    @GetMapping("")
    List<MedicalCardDto> getMedicalCardByListId(@RequestParam List<Long> id) {
        List<MedicalCardEntity> medicalCardEntity = medicalCardRepository.findByListId(id);
        return medicalCardEntity.stream().map(el -> modelMapper.map(el, MedicalCardDto.class)).collect(Collectors.toList());
    }
}