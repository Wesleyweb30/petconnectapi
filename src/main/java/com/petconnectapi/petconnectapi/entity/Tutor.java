package com.petconnectapi.petconnectapi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petconnectapi.petconnectapi.dto.tutorDTO.TutorSaveRecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tutors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String tutorName;

    @Column(nullable = true, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String cpf;

    @Column(nullable = true)
    private char sex;

    @Column(nullable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtNasc;
    
    public Tutor(TutorSaveRecord tutor){
        this.tutorName = tutor.tutorName();
        this.cpf = tutor.cpf();
        this.email = tutor.email();
        this.sex = tutor.sex();
        this.dtNasc = tutor.dtNasc();
    }
    
}
