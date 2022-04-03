package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SeatDto implements EntityDto {

    private static final double VIP_PRICE_COEFFICIENT = 30;

    private Long id;

    private int seatNumber;

    private boolean isVip;

    private TicketDto ticket;
}
