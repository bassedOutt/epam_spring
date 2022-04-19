package com.epam.spring.homework3.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    public User(){}

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @Column(unique = true)
    private String email;
    private String password;
    private boolean isAdmin = false;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Ticket> tickets;
}
