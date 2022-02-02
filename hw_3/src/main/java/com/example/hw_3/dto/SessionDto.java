package com.example.hw_3.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
public class SessionDto  {
    private int id;
    private MovieDto movie;
    private Time startTime;
    private Time endTime;
    private Date date;
    private PricingDto pricing;
    private List<SeatDto> seats;

    public long getFreeSeats() {
        return seats.stream().filter(seat -> !seat.isTaken()).count();
    }
}
