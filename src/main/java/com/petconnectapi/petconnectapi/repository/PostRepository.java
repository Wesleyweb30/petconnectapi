package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface PostRepository extends JpaRepository<com.petconnectapi.petconnectapi.entity.Post, Long>{
    
}

