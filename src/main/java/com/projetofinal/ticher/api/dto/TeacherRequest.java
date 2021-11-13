package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Teacher;
import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class TeacherRequest {

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

    private final List<SubjectRequest> subjects;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TeacherRequest(String name, String email, String password, List<SubjectRequest> subjects) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
    }

    public Teacher toTeacher() {
        return new Teacher(this.name, this.subjects, this.email, this.password);
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
