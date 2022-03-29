package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Seat {

    public Seat(){

    }

    private static final double VIP_PRICE_COEFFICIENT = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number",nullable = false)
    private int seatNumber;

    @Column(name = "is_vip")
    private Boolean isVip;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "session_id",nullable = false)
    private Session session;

    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public boolean isTaken() {
        return user != null;
    }
}
