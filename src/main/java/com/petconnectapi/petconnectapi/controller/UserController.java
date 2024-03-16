package com.petconnectapi.petconnectapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petconnectapi.petconnectapi.entity.User;
import com.petconnectapi.petconnectapi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getMethodName() {
        List<User> list = repository.findAll();
        return list; 
    }
    
}
