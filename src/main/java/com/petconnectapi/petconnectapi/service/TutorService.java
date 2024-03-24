package com.petconnectapi.petconnectapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petconnectapi.petconnectapi.dto.tutorDTO.TutorRecord;
import com.petconnectapi.petconnectapi.dto.tutorDTO.TutorSaveRecord;
import com.petconnectapi.petconnectapi.entity.Tutor;
import com.petconnectapi.petconnectapi.repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public TutorSaveRecord tutorSave(TutorSaveRecord tutor) {
        Tutor tutorobj = new Tutor(tutor);
        repository.save(tutorobj);
        return tutor;
    }

    public List<TutorRecord> findAll() {
        List<Tutor> tutores = repository.findAll();
        return tutores.stream()
                // Aqui usando a referência de método para mapToTutorRecord
                .map(this::mapToTutorRecord)
                .collect(Collectors.toList());
    }

    public Optional<TutorRecord> findById(Long id) {
        Optional<Tutor> tutorOptional = repository.findById(id);
        // Verifica se o tutor foi encontrado
        if (tutorOptional.isPresent()) {
            Tutor tutor = tutorOptional.get();
            TutorRecord tutorRecord = new TutorRecord(tutor);
            return Optional.of(tutorRecord);
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Método privado para mapear um objeto Tutor para um objeto TutorRecord
    private TutorRecord mapToTutorRecord(Tutor tutor) {
        return new TutorRecord(tutor);
    }
}
