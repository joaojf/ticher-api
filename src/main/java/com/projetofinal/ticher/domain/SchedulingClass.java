package com.projetofinal.ticher.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
abstract class SchedulingClass {
    // add regex
    @Column(nullable = false)
    private LocalDate date;

    // add regex
    @Column(nullable = false)
    private String hours;
}
