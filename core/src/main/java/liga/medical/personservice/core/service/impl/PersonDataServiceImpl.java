package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.dto.PersonDataDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonDataServiceImpl implements PersonDataService {

    final PersonDataRepository repository;

    private final ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public PersonDataServiceImpl(PersonDataRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = new BCryptPasswordEncoder(10);
    }

    @Override
    public List<PersonDataDto> findAll() {
        List<PersonDataEntity> personDataList = repository.findAll();
        return personDataList.stream().map(el -> modelMapper.map(el, PersonDataDto.class)).collect(Collectors.toList());
    }

    @Override
    public PersonDataDto findById(Long id) {
        PersonDataEntity personData = repository.findById(id);
        return modelMapper.map(personData, PersonDataDto.class);
    }

    @Override
    public List<PersonDataDto> findByListId(List<Long> listId) {
        List<PersonDataEntity> medicalCardList = repository.findByListId(listId);
        return medicalCardList.stream().map(el -> modelMapper.map(el, PersonDataDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insertAll(List<PersonDataDto> personDataDtoList) {
        List<PersonDataEntity> personDataList = personDataDtoList.stream().map(el -> modelMapper.map(el, PersonDataEntity.class)).collect(Collectors.toList());
        repository.insertAll(personDataList);
    }

    @Override
    public void updateById(PersonDataDto personDataDto) {
        PersonDataEntity personData = modelMapper.map(personDataDto, PersonDataEntity.class);
        repository.updateById(personData);
    }

    @Override
    public void insert(PersonDataDto personDataDto) {
        PersonDataEntity personData = modelMapper.map(personDataDto, PersonDataEntity.class);
        if (personData.getId() == null) repository.insert(personData);
        else repository.updateById(personData);
    }

    public void insertUser(PersonDataEntity personDataEntity) {
        repository.insertUser(personDataEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public PersonDataEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return findByEmail(email);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}