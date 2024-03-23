package com.petconnectapi.petconnectapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petconnectapi.petconnectapi.entity.Pet;
import com.petconnectapi.petconnectapi.entity.Post;
import com.petconnectapi.petconnectapi.repository.PetRepository;
import com.petconnectapi.petconnectapi.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;



    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postRepository.save(post);         
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        post.setId(updatedPost.getId());
        post.setAtivo(updatedPost.getAtivo());
        post.setData(updatedPost.getData());
        post.setImagem(updatedPost.getImagem());
        post.setTexto(updatedPost.getTexto());
        post.setTitulo(updatedPost.getTitulo());


        Post updated = postRepository.save(post);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
