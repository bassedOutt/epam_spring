package com.epam.spring.homework3.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;


@Data
@Entity
public class Ticket {

    public Ticket(){}

    @Id
    private Long id;

    @Column(nullable = false)
    private double price;

    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "session_id")
    private Long sessionId;

}
