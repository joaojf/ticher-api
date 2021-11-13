package com.projetofinal.ticher.domain;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusClassEnum statusClass;

    @OneToOne
    private AvailabilityTeacher availabilityTeacher;

    @OneToOne
    private StudentScheduling agendamento;

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    public Class() {}

}
