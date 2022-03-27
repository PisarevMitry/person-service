package liga.medical.personservice.core.service.impl;

import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.service.AddressService;
import liga.medical.personservice.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    final AddressRepository repository;

    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository repository, ModelMapper modelMapper) {this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressDto> findAll() {
        List<AddressEntity> addressList = repository.findAll();
        return addressList.stream().map(el -> modelMapper.map(el, AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Long id) {
        AddressEntity address = repository.findById(id);
        return modelMapper.map(address, AddressDto.class);
    }

    @Override
    public List<AddressDto> findByListId(List<Long> listId) {
        List<AddressEntity> addressList = repository.findByListId(listId);
        return addressList.stream().map(el -> modelMapper.map(el, AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insert(AddressDto addressDto) {
        AddressEntity address = modelMapper.map(addressDto, AddressEntity.class);
        if (address.getId() == null) {
            repository.insert(address);
        } else {
            repository.updateById(address);
        }
    }

    @Override
    public void insertAll(List<AddressDto> addressDtoList) {
        List<AddressEntity> addressList = addressDtoList.stream().map(el -> modelMapper.map(el, AddressEntity.class)).collect(Collectors.toList());
        repository.insertAll(addressList);
    }

    @Override
    public void updateById(AddressDto addressDto) {
        AddressEntity address = modelMapper.map(addressDto, AddressEntity.class);
        repository.updateById(address);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }
}