package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
@Entity
public class Seat  {
    private String id;
    private int row;
    private int seatNumber;
    private boolean isVip;
    private boolean isTaken;
    private Session session;
}
