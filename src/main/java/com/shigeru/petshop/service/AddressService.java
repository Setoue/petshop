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

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        return address.get();
    }

    public void create(Address address){
        addressRepository.save(address);
    }

    public Address update(Long id, Address address){
        Optional<Address> existingAddress = addressRepository.findById(id);
        if(existingAddress.isPresent()){
            Address updatedAddress = existingAddress.get();
            updatedAddress.setStreet(address.getStreet());
            updatedAddress.setCity(address.getCity());
            updatedAddress.setState(address.getState());
            updatedAddress.setZipCode(address.getZipCode());

            return addressRepository.save(updatedAddress);
        }else {
          return null;
        }
    }

    public void delete(Long id){
        addressRepository.deleteById(id);
    }
}
