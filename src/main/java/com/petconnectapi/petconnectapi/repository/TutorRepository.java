package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petconnectapi.petconnectapi.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long>  {
    
}
