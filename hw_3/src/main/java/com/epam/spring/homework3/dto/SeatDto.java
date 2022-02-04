package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatDto implements EntityDto{
    private Long id;
    private int row;
    private int seatNumber;
    private boolean isVip;
    private boolean isTaken;
    private SessionDto session;
    private MovieDto movie;
}
