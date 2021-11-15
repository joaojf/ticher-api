package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.SchedulingClass;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

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

    public TeacherAvailability(LocalDate date, String hours, Teacher teachers) {
        super.date = date;
        super.hours = hours;
        this.teachers = teachers;
    }

}
