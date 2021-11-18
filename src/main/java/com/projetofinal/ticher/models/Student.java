package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.Login;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Student extends Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String dataNasc;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Student() {}

    public Student(String name, String email, String password) {
        this.name = name;
        super.email = email;
        super.password = password;
    }

}
