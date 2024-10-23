package com.shigeru.petshop.service;

import com.shigeru.petshop.entities.Owner;
import com.shigeru.petshop.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAll(){
        return ownerRepository.findAll();
    }

    public Owner findById(Long id){
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.get();
    }

    public void create(Owner owner){
        ownerRepository.save(owner);
    }

    public Owner update(Long id, Owner owner){
        Optional<Owner> existingOwner = ownerRepository.findById(id);
        if(existingOwner.isEmpty()){
            return null;
        }
        Owner updatedOwner = existingOwner.get();
        updatedOwner.setAddress(owner.getAddress());
        updatedOwner.setName(owner.getName());
        updatedOwner.setEmail(owner.getEmail());
        updatedOwner.setPhoneNumber(owner.getPhoneNumber());

        return ownerRepository.save(updatedOwner);
    }

    public void delete(Long id){
        ownerRepository.deleteById(id);
    }
}
