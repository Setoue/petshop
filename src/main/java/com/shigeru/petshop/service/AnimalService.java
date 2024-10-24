package com.shigeru.petshop.service;

import com.shigeru.petshop.entities.Animal;
import com.shigeru.petshop.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public Animal findById(Long id){
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.get();
    }

    public void create(Animal animal){
        animalRepository.save(animal);
    }

    public Animal update(Long id, Animal animal){
        Optional<Animal> existingAnimal = animalRepository.findById(id);

        if(existingAnimal.isEmpty()){
            return null;
        }

        Animal updatedAnimal = existingAnimal.get();
        updatedAnimal.setName(animal.getName());
        updatedAnimal.setTypeAnimal(animal.getTypeAnimal());
        updatedAnimal.setAge(animal.getAge());
        updatedAnimal.setBreed(animal.getBreed());

        return animalRepository.save(updatedAnimal);
    }

    public void delete(Long id){
        animalRepository.deleteById(id);
    }
}
