package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.dto.ContactDto;
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
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/save")
    void saveNewContact(@RequestBody @Valid ContactDto contactDTO) {
        ContactEntity contactEntity = modelMapper.map(contactDTO, ContactEntity.class);
        contactRepository.insert(contactEntity);
    }

    @PostMapping("/save-all")
    void saveNewContact(@RequestBody @Valid List<ContactDto> contactDTO) {
        List<ContactEntity> contactEntityList = contactDTO.stream().map(el -> modelMapper.map(el, ContactEntity.class)).collect(Collectors.toList());
        contactRepository.insertAll(contactEntityList);
    }

    @GetMapping("/{id}")
    ContactDto getContactById(@PathVariable Long id) {
        ContactEntity contactEntity = contactRepository.findById(id);
        return modelMapper.map(contactEntity, ContactDto.class);
    }

    @GetMapping("")
    List<ContactDto> getContactByListId(@RequestParam List<Long> id) {
        List<ContactEntity> contactEntity = contactRepository.findByListId(id);
        return contactEntity.stream().map(el -> modelMapper.map(el, ContactDto.class)).collect(Collectors.toList());
    }
}