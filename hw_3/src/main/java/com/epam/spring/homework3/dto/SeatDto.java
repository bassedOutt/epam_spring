package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SeatDto implements EntityDto{
    private String id;
    private int row;
    private int seatNumber;
    private boolean isVip;
    private boolean isTaken;
    private SessionDto session;
}
