package com.projetofinal.ticher.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.projetofinal.ticher.models.Student;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StudentRequest {

    @NotBlank
    @Size(min=2, max=200)
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @Size(min=4)
    private final String password;

    @CPF
    @NotBlank
    private final String cpf;

    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$", message = "malformed number! expected: (xx)xxxxx-xxxx")
    @NotBlank
    private final String numberPhone;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentRequest(String name, String email, String password, String cpf, String numberPhone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
    }

    public Student toStudent(){
        return new Student(this.name, this.email, this.password, this.cpf, this.numberPhone);
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + numberPhone + '\'' +
                '}';
    }

}
