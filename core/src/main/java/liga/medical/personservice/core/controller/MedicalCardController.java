package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.dto.MedicalCardDto;
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

    //fixme в домашке здесь должен быть интерфейс сервиса
    @Autowired
    private MedicalCardRepository medicalCardRepository;

    //fixme в домашке он должен быть бином
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewMedicalCard(@RequestBody @Valid MedicalCardDto medicalCard) {
        MedicalCardEntity cardEntity = modelMapper.map(medicalCard, MedicalCardEntity.class);
        medicalCardRepository.insert(cardEntity);
    }

    @PostMapping("/save-all")
    void saveNewMedicalCard(@RequestBody @Valid List<MedicalCardDto> medicalCard) {
        List<MedicalCardEntity> cardEntityList = medicalCard.stream()
                .map(el -> modelMapper.map(el, MedicalCardEntity.class))
                .collect(Collectors.toList());
        medicalCardRepository.insertAll(cardEntityList);
    }

    @GetMapping("/{id}")
    MedicalCardDto getCardById(@PathVariable Long id) {
        MedicalCardEntity medicalCard = medicalCardRepository.findById(id);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    @GetMapping("")
    List<MedicalCardDto> getCardByIds(@RequestParam List<Long> ids) {
        List<MedicalCardEntity> medicalCard = medicalCardRepository.findByIds(ids);
        return medicalCard.stream()
                .map(el -> modelMapper.map(el, MedicalCardDto.class))
                .collect(Collectors.toList());
    }
}
