package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.model.Ticket;
import com.epam.spring.homework3.model.User;

public class SeatDto {

    private static final double VIP_PRICE_COEFFICIENT = 30;

    private Long id;

    private int seatNumber;

    private boolean isVip;

    private Session session;

    private User user;

    private Ticket ticket;

    public boolean isTaken() {
        return user != null;
    }
}
