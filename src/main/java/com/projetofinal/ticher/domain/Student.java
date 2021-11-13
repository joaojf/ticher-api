package com.projetofinal.ticher.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Student extends Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Student() {}

}
