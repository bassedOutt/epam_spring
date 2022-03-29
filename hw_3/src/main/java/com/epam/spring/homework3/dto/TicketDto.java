package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private double price;
    private Seat seat;
    private User user;
}
