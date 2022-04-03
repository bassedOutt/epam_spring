package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private Double price;
    private SeatDto seat;
    private UserDto user;
}
