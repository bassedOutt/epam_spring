package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class SeatDto implements EntityDto{

    private String id;

    @Min(value = 1,message = "Row can not be less than 1")
    @Max(value = 5,message = "Row can not be more than 5")
    private int row;

    @Min(value = 1,message = "Seat number can not be less than 1")
    @Max(value = 10,message = "Seat can not be more than 10")
    private int seatNumber;

    private boolean isVip;
    private boolean isTaken;

    @NotNull( message = "Session can not be null")
    private SessionDto session;
}
