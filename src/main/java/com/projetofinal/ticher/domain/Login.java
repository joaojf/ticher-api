package com.projetofinal.ticher.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Login {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

}
