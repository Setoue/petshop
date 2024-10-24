package com.shigeru.petshop.resouces;

import com.shigeru.petshop.entities.Address;
import com.shigeru.petshop.entities.Animal;
import com.shigeru.petshop.entities.Owner;
import com.shigeru.petshop.service.AnimalService;
import com.shigeru.petshop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerResource {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private AnimalService animalService;

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

    @PostMapping(value = "/{id}/animal")
    public ResponseEntity<Void> create(@RequestBody Animal animal, @PathVariable Long id){
        animalService.create(animal, id);
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

    @PutMapping(value = "/{id}/animal/{idAnimal}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @PathVariable Long idAnimal, @RequestBody Animal animal){
        Animal obj = animalService.updateAnimal(id, idAnimal, animal);
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
