package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
@Entity
public class Session{
    private String id;
    private Movie movie;
    private Time startTime;
    private Time endTime;
    private Date date;
    private Pricing pricing;

    @OneToMany
    private List<Seat> seats;

    public long getFreeSeats() {
        return seats.stream().filter(seat -> !seat.isTaken()).count();
    }
}
