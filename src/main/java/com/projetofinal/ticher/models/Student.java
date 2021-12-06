package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.Registration;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Student extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Student() {}

    public Student(String name, String email, String password, String cpf, String numberPhone) {
        super.name = name;
        super.email = email;
        super.password = password;
        super.cpf = cpf;
        super.numberPhone = numberPhone;
    }

}
