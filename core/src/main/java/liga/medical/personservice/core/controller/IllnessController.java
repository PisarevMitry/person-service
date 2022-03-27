package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.IllnessService;
import liga.medical.personservice.dto.ContactDto;
import liga.medical.personservice.dto.IllnessDto;
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
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @PostMapping("/save")
    void saveNewIllness(@RequestBody @Valid IllnessDto illnessDTO) {
        illnessService.insert(illnessDTO);
    }

    @PostMapping("/save-all")
    void saveNewIllness(@RequestBody @Valid List<IllnessDto> illnessListDTO) {
        illnessService.insertAll(illnessListDTO);
    }

    @GetMapping("/{id}")
    IllnessDto getIllnessById(@PathVariable Long id) {
        return illnessService.findById(id);
    }

    @GetMapping("/sort")
    List<IllnessDto> getIllnessByListId(@RequestParam List<Long> listId) {
        return illnessService.findByListId(listId);
    }

    @GetMapping("")
    List<IllnessDto> getAllIllness() {
        return illnessService.findAll();
    }
}