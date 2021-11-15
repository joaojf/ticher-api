package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.SchedulingClass;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class TeacherAvailability extends SchedulingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Teacher teachers;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private TeacherAvailability() {
    }

}
