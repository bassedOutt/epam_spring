package com.epam.spring.homework3.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@Entity
public class Ticket {

    public Ticket(){}

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long price;

    @OneToOne
    @JoinColumn(name = "seat_id", unique = true, referencedColumnName = "id")
    private Seat seat;

}
