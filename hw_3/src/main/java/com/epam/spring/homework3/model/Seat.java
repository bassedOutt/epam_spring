package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Seat {

    private static final double VIP_PRICE_COEFFICIENT = 30;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "is_vip")
    private boolean isVip;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public boolean isTaken() {
        return user != null;
    }
}
