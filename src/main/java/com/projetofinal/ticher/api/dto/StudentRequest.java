package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Student;

import javax.validation.constraints.*;

public class StudentRequest {

    @NotNull
    @NotBlank
    @Min(2)
    @Max(150)
    private final String name;

    @NotNull
    @NotBlank
    @Email
    private final String email;

    @NotNull
    @NotBlank
    @Min(4)
    @Max(150)
    private final String password;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public Student toStudent(){
        return new Student(this.name, this.email, this.password);
    }

}
