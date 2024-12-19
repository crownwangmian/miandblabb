package com.iths.controller;

import com.iths.domain.pojo.Address;
import com.iths.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }

    @GetMapping("/{id}")
    public Address findAddressById(@PathVariable int id) {
        return addressService.findAddressById(id);
    }

    @GetMapping
    public List<Address> findAllAddresses() {
        return addressService.findAllAddresses();
    }

}
