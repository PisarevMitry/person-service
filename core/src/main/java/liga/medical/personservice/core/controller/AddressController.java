package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.AddressEntity;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.dto.AddressDto;
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
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/save")
    void saveNewAddress(@RequestBody @Valid AddressDto addressDTO) {
        AddressEntity addressEntity = modelMapper.map(addressDTO, AddressEntity.class);
        addressRepository.insert(addressEntity);
    }

    @PostMapping("/save-all")
    void saveNewAddress(@RequestBody @Valid List<AddressDto> addressDTO) {
        List<AddressEntity> addressEntityList = addressDTO.stream().map(el -> modelMapper.map(el, AddressEntity.class)).collect(Collectors.toList());
        addressRepository.insertAll(addressEntityList);
    }

    @GetMapping("/{id}")
    AddressDto getAddressById(@PathVariable Long id) {
        AddressEntity addressEntity = addressRepository.findById(id);
        return modelMapper.map(addressEntity, AddressDto.class);
    }

    @GetMapping("")
    List<AddressDto> getAddressByListId(@RequestParam List<Long> id) {
        List<AddressEntity> addressEntity = addressRepository.findByListId(id);
        return addressEntity.stream().map(el -> modelMapper.map(el, AddressDto.class)).collect(Collectors.toList());
    }
}