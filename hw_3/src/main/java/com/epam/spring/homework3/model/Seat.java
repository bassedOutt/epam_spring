package com.epam.spring.homework3.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString(exclude = "session")

public class Seat implements Serializable {

    private static final long serialVersionUID = 2758698409013395067L;

    public Seat() {

    }

    public static final Long VIP_PRICE = 50L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    @Column(name = "is_vip", columnDefinition = "boolean not null default 0")
    private Boolean isVip;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;
}
