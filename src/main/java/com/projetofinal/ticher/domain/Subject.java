package com.projetofinal.ticher.domain;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Subject() {
    }

}
