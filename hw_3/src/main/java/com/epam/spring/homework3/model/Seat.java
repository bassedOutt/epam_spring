package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat implements Entity {
    private Long id;
    private int row;
    private int seatNumber;
    private boolean isVip;
    private boolean isTaken;
    private Session session;
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}