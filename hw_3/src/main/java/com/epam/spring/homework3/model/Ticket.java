package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket implements Entity {
    private Long id;
    private User user;
    private double price;
    private Session Session;
    private Seat seat;
}
