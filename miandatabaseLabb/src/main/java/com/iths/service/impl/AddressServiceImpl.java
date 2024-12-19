package com.iths.service.impl;

import com.iths.DAO.AddressDAO;
import com.iths.domain.pojo.Address;
import com.iths.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDAO addressDAO;

    @Override
    public Address addAddress(Address address) {
        return addressDAO.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressDAO.save(address);
    }

    @Override
    public void deleteAddress(int id) {
        addressDAO.deleteById(id);
    }

    @Override
    public Address findAddressById(int id) {
        return addressDAO.findById(id).orElse(null);
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressDAO.findAll();
    }

}
