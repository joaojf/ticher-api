package com.projetofinal.ticher.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class StudentScheduling extends SchedulingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private StudentScheduling() {
    }

}
