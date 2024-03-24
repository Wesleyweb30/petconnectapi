package com.petconnectapi.petconnectapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petconnectapi.petconnectapi.dto.tutorDTO.TutorRecord;
import com.petconnectapi.petconnectapi.dto.tutorDTO.TutorSaveRecord;
import com.petconnectapi.petconnectapi.service.TutorService;

@RestController
@RequestMapping("/tutores")

public class TutorController {

    @Autowired
    private TutorService service;

    @GetMapping
    public List<TutorRecord> findAllTutors() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<TutorSaveRecord> tutorSave(@RequestBody TutorSaveRecord tutor) {
        service.tutorSave(tutor);
        return ResponseEntity.ok().body(tutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorRecord> findById(@PathVariable Long id) {
        Optional<TutorRecord> tutorRecordOptional = service.findById(id);
        if (tutorRecordOptional.isPresent()) {
            return ResponseEntity.ok().body(tutorRecordOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
