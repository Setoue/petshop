package com.shigeru.petshop.repositories;

import com.shigeru.petshop.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
