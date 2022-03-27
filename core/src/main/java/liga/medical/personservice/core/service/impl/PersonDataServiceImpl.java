package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.PersonDataEntity;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.dto.PersonDataDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonDataServiceImpl implements PersonDataService {

    @Autowired
    PersonDataRepository repository;

    @Autowired
    private ModelMapper modelMapper;

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
        if (personData.getId() == null)
            repository.insert(personData);
        else
            repository.updateById(personData);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}