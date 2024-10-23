package com.shigeru.petshop.resouces;

import com.shigeru.petshop.entities.Address;
import com.shigeru.petshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll(){
        List<Address> list = addressService.findAll();
        return ResponseEntity.status(201).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id){
        Address address = addressService.findById(id);
        return ResponseEntity.status(201).body(address);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Address address){
        addressService.create(address);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @RequestBody Address address){
        Address updateAddress = addressService.update(id, address);
        if(updateAddress != null){
            return ResponseEntity.status(201).body(updateAddress);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Address>> delete(@PathVariable Long id){
        addressService.delete(id);
        List<Address> list = addressService.findAll();
        return ResponseEntity.status(201).body(list);
    }

}
