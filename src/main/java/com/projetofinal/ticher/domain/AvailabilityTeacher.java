package com.projetofinal.ticher.domain;

import javax.persistence.*;

@Entity
public class AvailabilityTeacher extends  SchedulingClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Teacher teachers;

    @Deprecated
    private AvailabilityTeacher() {
    }

}
