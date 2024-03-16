package com.petconnectapi.petconnectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petconnectapi.petconnectapi.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
    
}
