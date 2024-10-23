package com.shigeru.petshop.resouces;

import com.shigeru.petshop.entities.Animal;
import com.shigeru.petshop.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalResource {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Animal>> findAll(){
        List<Animal> animals = animalService.findAll();
        return ResponseEntity.status(201).body(animals);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id){
        Animal animal = animalService.findById(id);
        return ResponseEntity.status(201).body(animal);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Animal animal){
        animalService.create(animal);
        return ResponseEntity.status(201).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal){
        Animal obj = animalService.update(id, animal);
        if(obj != null){
            return ResponseEntity.status(201).body(obj);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Animal>> delete(@PathVariable Long id){
        animalService.delete(id);
        List<Animal> list = animalService.findAll();
        return ResponseEntity.status(201).body(list);
    }
}
