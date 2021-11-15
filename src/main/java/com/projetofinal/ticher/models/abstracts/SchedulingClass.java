package com.projetofinal.ticher.models.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class SchedulingClass {

    @Column(nullable = false)
    protected LocalDate date;

    @Column(nullable = false)
    protected String hours;

    public LocalDate getDate() {
        return date;
    }

    public String getHours() {
        return hours;
    }

}
