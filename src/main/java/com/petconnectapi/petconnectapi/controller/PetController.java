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

import com.petconnectapi.petconnectapi.entity.Pet;
import com.petconnectapi.petconnectapi.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        @SuppressWarnings("null")
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        @SuppressWarnings("null")
        Pet createPet = petRepository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet updatePet) {
        @SuppressWarnings("null")
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setId(updatePet.getId());
        pet.setBirthdata(updatePet.getBirthdata());
        pet.setName(updatePet.getName());
        pet.setRace(updatePet.getRace());
        pet.setSize(updatePet.getSize());
        pet.setStatus(updatePet.isStatus());
        pet.setType(updatePet.getType());

        Pet update = petRepository.save(pet);
        return ResponseEntity.ok(update);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
