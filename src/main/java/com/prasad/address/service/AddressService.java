package com.prasad.address.service;

import com.prasad.address.model.Address;
import com.prasad.address.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;

    public Optional<Address> getAddressById(int id) {
        return addressRepo.findById(id);
    }
}
