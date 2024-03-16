package com.petconnectapi.petconnectapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petconnectapi.petconnectapi.entity.Pets;
import com.petconnectapi.petconnectapi.repository.PetsRepository;

@RestController
@RequestMapping("/pets")
public class PetsController {
    
    @Autowired
    private PetsRepository petsRepository;

    @GetMapping
    public List<Pets> getMethodName() {
        List<Pets> list = petsRepository.findAll();
        return list; 
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Pets> getPostById(@PathVariable Long id) {
        @SuppressWarnings("null")
        Pets post = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Pets> createPost(@RequestBody Pets post) {
        @SuppressWarnings("null")
        Pets createdPost = petsRepository.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pets> updatePost(@PathVariable Long id, @RequestBody Pets updatedPost) {
        @SuppressWarnings("null")
        Pets post = petsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        post.setId(updatedPost.getId());
        post.setBirthdata(updatedPost.getBirthdata());
        post.setName(updatedPost.getName());
        post.setRace(updatedPost.getRace());
        post.setSize(updatedPost.getSize());
        post.setStatus(updatedPost.isStatus());
        post.setType(updatedPost.getType());


        Pets updated = petsRepository.save(post);
        return ResponseEntity.ok(updated);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        petsRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}




