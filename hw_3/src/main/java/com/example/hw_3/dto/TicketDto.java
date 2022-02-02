package com.example.hw_3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto  {
    private int id;
    private UserDto user;
    private double price;
    private SessionDto Session;
    private SeatDto seat;
}
