package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.MedicalCardService;
import liga.medical.personservice.dto.IllnessDto;
import liga.medical.personservice.dto.MedicalCardDto;
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
@RequestMapping("/medical-card")
public class MedicalCardController {

    @Autowired
    private MedicalCardService medicalCardService;

    @PostMapping("/save")
    void saveNewMedicalCard(@RequestBody @Valid MedicalCardDto medicalCardDTO) {
        medicalCardService.insert(medicalCardDTO);
    }

    @PostMapping("/save-all")
    void saveNewMedicalCard(@RequestBody @Valid List<MedicalCardDto> medicalCardListDTO) {
        medicalCardService.insertAll(medicalCardListDTO);
    }

    @GetMapping("/{id}")
    MedicalCardDto getMedicalCardById(@PathVariable Long id) {
        return medicalCardService.findById(id);
    }

    @GetMapping("/sort")
    List<MedicalCardDto> getMedicalCardByListId(@RequestParam List<Long> listId) {
        return medicalCardService.findByListId(listId);
    }

    @GetMapping("")
    List<MedicalCardDto> getAllMedicalCard() {
        return medicalCardService.findAll();
    }
}