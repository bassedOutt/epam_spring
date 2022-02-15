package com.epam.spring.homework3.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Builder
@Entity
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;

    @OneToMany
    private List<Ticket> tickets;
}
