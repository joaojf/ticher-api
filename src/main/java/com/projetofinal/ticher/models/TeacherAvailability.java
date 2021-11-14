package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.SchedulingClass;

import javax.persistence.*;

@Entity
public class TeacherAvailability extends SchedulingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Teacher teachers;

    @Deprecated
    private TeacherAvailability() {
    }

}
