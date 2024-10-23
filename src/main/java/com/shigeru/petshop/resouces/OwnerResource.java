package com.shigeru.petshop.resouces;

import com.shigeru.petshop.entities.Owner;
import com.shigeru.petshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerResource {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<Owner>> findAll(){
        List<Owner> list = ownerService.findAll();
        return ResponseEntity.status(201).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id){
        Owner owner = ownerService.findById(id);
        return ResponseEntity.status(201).body(owner);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Owner owner){
        ownerService.create(owner);
        return ResponseEntity.status(201).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Owner> update(@PathVariable Long id, @RequestBody Owner owner){
        Owner obj = ownerService.update(id, owner);
        if(obj != null){
            return ResponseEntity.status(201).body(obj);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Owner>> delete(@PathVariable Long id){
        ownerService.delete(id);
        List<Owner> list = ownerService.findAll();
        return ResponseEntity.status(201).body(list);
    }
}
