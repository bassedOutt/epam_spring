package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Seat {

    public Seat(){

    }

    public static final Long VIP_PRICE = 50L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number",nullable = false)
    private int seatNumber;

    @Column(name = "is_vip")
    private boolean isVip = false;

    @Column(name = "session_id")
    private Long sessionId;

    @JsonIgnore
    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    private Ticket ticket;
}
