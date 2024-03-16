package com.petconnectapi.petconnectapi.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petconnectapi.petconnectapi.entity.Tutor;
import com.petconnectapi.petconnectapi.repository.TutorRepository;

@RestController
@RequestMapping("/tutores")

public class TutorController {

   
    @SuppressWarnings("null")
    @PostMapping
    public ResponseEntity<Tutor> createdTutor(@RequestBody Tutor tutor) {
         tutor = tutorRepository.save(tutor); 
        return ResponseEntity.ok().body(tutor);
    }

    @GetMapping
    public List<Tutor> findByAll() {
        return tutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> findTutorById(@PathVariable("id") long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new RuntimeException("tutor não encontrado"));
        return ResponseEntity.ok(tutor);

    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        tutorRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable("id") long id, @RequestBody Tutor tutor) {
        Optional<Tutor> tutorOpt = tutorRepository.findById(id);
        if (tutorOpt.isPresent()) {
            Tutor tutorObj = tutorOpt.get();
            tutorObj.setTutorName(tutor.getTutorName());
            tutorObj.setEmail(tutor.getEmail());
            tutorObj.setCpf(tutor.getCpf());
            tutorObj.setSex(tutor.getSex());
            tutorObj.setDtNasc(tutor.getDtNasc());
            Tutor tutorRes = tutorRepository.save(tutorObj);
                    
            
            return ResponseEntity.ok(tutorRes);
        }
        return null;       

}

    @Autowired
    private TutorRepository tutorRepository;

}
