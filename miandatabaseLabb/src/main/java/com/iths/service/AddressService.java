package com.iths.service;

import com.iths.domain.pojo.Address;

import java.util.List;

public interface AddressService {
    Address addAddress(Address address);

    Address updateAddress(Address address);

    void deleteAddress(int id);

    Address findAddressById(int id);

    List<Address> findAllAddresses();

}
