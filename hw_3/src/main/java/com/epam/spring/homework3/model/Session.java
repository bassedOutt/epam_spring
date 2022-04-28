package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
public class Session implements Entity{
    private String id;
    private Movie movie;
    private Time startTime;
    private Time endTime;
    private Date date;
    private Pricing pricing;
    private List<Seat> seats;

    public long getFreeSeats() {
        return seats.stream().filter(seat -> !seat.isTaken()).count();
    }
}
