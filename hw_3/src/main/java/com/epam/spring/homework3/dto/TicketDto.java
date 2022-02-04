package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto implements EntityDto{
    private Long id;
    private UserDto user;
    private double price;
    private SessionDto Session;
    private SeatDto seat;
}
