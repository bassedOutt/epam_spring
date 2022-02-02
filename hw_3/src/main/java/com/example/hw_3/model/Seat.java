package com.example.hw_3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat implements Entity {
    private int id;
    private int row;
    private int seatNumber;
    private boolean isVip;
    private boolean isTaken;
    private Session session;
    private Movie movie;
}
