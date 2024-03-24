package com.petconnectapi.petconnectapi.dto.tutorDTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record TutorSaveRecord
(String tutorName, String email, String cpf, char sex,@JsonFormat(pattern = "dd/MM/yyyy") LocalDate dtNasc){}
