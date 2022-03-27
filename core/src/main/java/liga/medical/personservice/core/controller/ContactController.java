package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
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
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    void saveNewContact(@RequestBody @Valid ContactDto contactDTO) {
        contactService.insert(contactDTO);
    }

    @PostMapping("/save-all")
    void saveNewContact(@RequestBody @Valid List<ContactDto> contactListDTO) {
        contactService.insertAll(contactListDTO);
    }

    @GetMapping("/{id}")
    ContactDto getContactById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("")
    List<ContactDto> getContactByListId(@RequestParam List<Long> listId) {
        return contactService.findByListId(listId);
    }
}