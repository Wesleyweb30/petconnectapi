package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petconnectapi.petconnectapi.entity.Pet;


public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
