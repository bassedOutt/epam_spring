package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
public class SessionDto implements EntityDto {
    private Long id;
    private MovieDto movie;
    private Time startTime;
    private Time endTime;
    private Date date;
    private PricingDto pricing;
    private List<SeatDto> seats;

    public long getFreeSeats() {
        return seats.stream().filter(seat -> !seat.isTaken()).count();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
