package com.projetofinal.ticher.models.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Registration {

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String cpf;

    @Column(nullable = false)
    protected String numberPhone;

    @Column(nullable = false, unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

    public String getName() { return name; }

    public String getEmail() {
        return email;
    }

}
