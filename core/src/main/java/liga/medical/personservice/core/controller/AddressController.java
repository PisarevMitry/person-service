package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.AddressService;
import liga.medical.personservice.dto.AddressDto;
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
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/save")
    void saveNewAddress(@RequestBody @Valid AddressDto addressDTO) {
        addressService.insert(addressDTO);
    }

    @PostMapping("/save-all")
    void saveNewAddress(@RequestBody @Valid List<AddressDto> addressListDTO) {
        addressService.insertAll(addressListDTO);
    }

    @GetMapping("/{id}")
    AddressDto getAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @GetMapping("/sort")
    List<AddressDto> getAddressByListId(@RequestParam List<Long> listId) {
        return addressService.findByListId(listId);
    }

    @GetMapping("")
    List<AddressDto> getAllAddress() {
        return addressService.findAll();
    }

}