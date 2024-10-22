package com.shigeru.petshop.repositories;

import com.shigeru.petshop.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Long, Animal> {
}
