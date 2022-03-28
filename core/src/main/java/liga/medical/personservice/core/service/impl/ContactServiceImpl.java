package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.ContactEntity;
import liga.medical.personservice.core.repository.ContactRepository;
import liga.medical.personservice.core.service.ContactService;
import liga.medical.personservice.dto.ContactDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    final ContactRepository repository;

    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ContactDto> findAll() {
        List<ContactEntity> contactList = repository.findAll();
        return contactList.stream().map(el -> modelMapper.map(el, ContactDto.class)).collect(Collectors.toList());
    }

    @Override
    public ContactDto findById(Long id) {
        ContactEntity contact = repository.findById(id);
        return modelMapper.map(contact, ContactDto.class);
    }

    @Override
    public List<ContactDto> findByListId(List<Long> listId) {
        List<ContactEntity> contactList = repository.findByListId(listId);
        return contactList.stream().map(el -> modelMapper.map(el, ContactDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insert(ContactDto contactDto) {
        ContactEntity contact = modelMapper.map(contactDto, ContactEntity.class);
        if (contact.getId() == null)
            repository.insert(contact);
        else
            repository.updateById(contact);
    }

    @Override
    public void insertAll(List<ContactDto> contactDtoList) {
        List<ContactEntity> contactList = contactDtoList.stream().map(el -> modelMapper.map(el, ContactEntity.class)).collect(Collectors.toList());
        repository.insertAll(contactList);
    }

    @Override
    public void updateById(ContactDto contactDto) {
        ContactEntity contact = modelMapper.map(contactDto, ContactEntity.class);
        repository.updateById(contact);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}