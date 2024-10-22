package com.shigeru.petshop.repositories;

import com.shigeru.petshop.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Long, Owner>{}
