package com.projetofinal.ticher.models;

import com.projetofinal.ticher.models.abstracts.Registration;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "teacher_subjects",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teachers")
    private final List<Evaluation> evaluations = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private final Instant createdIn = Instant.now();

    @Deprecated
    private Teacher() {
    }

    public Teacher(String name, List<Subject> subjectsList, String email, String password, String cpf, String phoneNumber) {
        super.email = email;
        super.password = password;
        super.name = name;
        super.cpf = cpf;
        super.numberPhone = phoneNumber;
        this.subjects = subjectsList;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                ", createdIn=" + createdIn +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
