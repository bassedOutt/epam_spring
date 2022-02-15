package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class TicketDto {

    private String id;

    @NotNull(message = "user can not be null")
    private UserDto user;

    @Min(value = 1, message = "price can not be null")
    private double price;
//
//    @NotNull(message = "session can not be null")
//    private SessionDto Session;
//
//    @NotNull(message = "seat can not be null")
//    private SeatDto seat;
}
