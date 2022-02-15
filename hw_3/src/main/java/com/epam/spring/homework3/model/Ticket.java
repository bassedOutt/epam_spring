package com.epam.spring.homework3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@Builder
@Entity
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    private double price;

    @ManyToOne
    @JoinColumn(name = "session_id",referencedColumnName = "id")
    private Session Session;
//    private Seat seat;
}
