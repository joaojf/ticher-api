package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetofinal.ticher.models.Student;
import com.projetofinal.ticher.models.StudentScheduling;
import com.projetofinal.ticher.repositories.StudentRepository;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class StudentSchedulingRequest {
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate date;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$", message = "expected pattern: 00:00")
    private final String hours;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentSchedulingRequest(LocalDate date, String hours) {
        this.date = date;
        this.hours = hours;
    }


    public StudentScheduling toStudentScheduling(Long idStudent, StudentRepository studentRepository) {
        Student student = studentRepository
                .findById(idStudent)
                .orElseThrow(() ->  new RuntimeException("teacher not found!"));
        return new StudentScheduling(this.date, this.hours, student);
    }
}
