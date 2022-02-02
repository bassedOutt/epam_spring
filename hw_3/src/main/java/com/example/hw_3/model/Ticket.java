package com.example.hw_3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket implements Entity {
    private int id;
    private User user;
    private double price;
    private Session Session;
    private Seat seat;
}
