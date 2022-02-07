package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketDto implements EntityDto{
    private String id;
    private UserDto user;
    private double price;
    private SessionDto Session;
    private SeatDto seat;
}
