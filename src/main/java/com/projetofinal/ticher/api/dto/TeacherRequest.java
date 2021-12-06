package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Subject;
import com.projetofinal.ticher.models.Teacher;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRequest {

    @NotBlank
    @Size(min=2, max=200)
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotNull
    @NotBlank
    @Size(min=4)
    private final String password;

    private final List<Long> subjectIds;

    @CPF
    @NotBlank
    private final String cpf;

    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$", message = "malformed number! expected: (xx)xxxxx-xxxx")
    @NotBlank
    private final String numberPhone;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TeacherRequest(String name, String email, String password, String cpf, String numberPhone, List<Long> subjectIds) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.subjectIds = subjectIds;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
    }

    public Teacher toTeacher(EntityManager entityManager) {
        List<Subject> subjectList = new ArrayList<>();
        for (Long idSubject : subjectIds){
            Subject subject = entityManager.find(Subject.class, idSubject);
            subjectList.add(subject);
        }
        return new Teacher(this.name, subjectList, this.email, this.password, this.cpf, this.numberPhone);
    }

    @Override
    public String toString() {
        return "TeacherRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", subjectIds=" + subjectIds +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + numberPhone + '\'' +
                '}';
    }

}
