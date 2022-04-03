package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private boolean isVip;

    @Column(name = "session_id")
    private Long sessionId;
    @JsonIgnore
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    private Ticket ticket;
}
