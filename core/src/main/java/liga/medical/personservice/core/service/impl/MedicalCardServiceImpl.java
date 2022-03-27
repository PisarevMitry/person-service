package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.MedicalCardEntity;
import liga.medical.personservice.core.repository.MedicalCardRepository;
import liga.medical.personservice.core.service.MedicalCardService;
import liga.medical.personservice.dto.MedicalCardDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    MedicalCardRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MedicalCardDto> findAll() {
        List<MedicalCardEntity> medicalCardList = repository.findAll();
        return medicalCardList.stream().map(el -> modelMapper.map(el, MedicalCardDto.class)).collect(Collectors.toList());
    }

    @Override
    public MedicalCardDto findById(Long id) {
        MedicalCardEntity medicalCard = repository.findById(id);
        return modelMapper.map(medicalCard, MedicalCardDto.class);
    }

    @Override
    public List<MedicalCardDto> findByListId(List<Long> listId) {
        List<MedicalCardEntity> medicalCardList = repository.findByListId(listId);
        return medicalCardList.stream().map(el -> modelMapper.map(el, MedicalCardDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insertAll(List<MedicalCardDto> medicalCard) {
        List<MedicalCardEntity> cardEntityList = medicalCard.stream().map(el -> modelMapper.map(el, MedicalCardEntity.class)).collect(Collectors.toList());
        repository.insertAll(cardEntityList);
    }

    @Override
    public void updateById(MedicalCardDto medicalCardDto) {
        MedicalCardEntity medicalCard = modelMapper.map(medicalCardDto, MedicalCardEntity.class);
        repository.updateById(medicalCard);
    }

    @Override
    public void insert(MedicalCardDto medicalCard) {
        MedicalCardEntity cardEntity = modelMapper.map(medicalCard, MedicalCardEntity.class);
        if (cardEntity.getId() == null)
            repository.insert(cardEntity);
        else
            repository.updateById(cardEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
