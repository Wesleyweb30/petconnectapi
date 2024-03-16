package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petconnectapi.petconnectapi.entity.Pets;


public interface PetsRepository extends JpaRepository<Pets, Long> {
    
}
