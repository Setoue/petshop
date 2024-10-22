package com.shigeru.petshop.service;

import com.shigeru.petshop.entities.Address;
import com.shigeru.petshop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        return address.get();
    }

    public Address create(Address address){
        return addressRepository.save(address);
    }
}
