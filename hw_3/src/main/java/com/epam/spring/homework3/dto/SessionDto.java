package com.epam.spring.homework3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@AllArgsConstructor
public class SessionDto implements EntityDto {

    public SessionDto() {

    }

    private Long id;

    @JsonInclude(NON_NULL)
    @NotNull(message = "movie can not be null")
    private MovieDto movie;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @NotNull(message = "start time can not be null")
    private LocalDateTime startTime;

    private PricingDto pricing;

    @JsonInclude(NON_NULL)
    private List<SeatDto> seats;

    @JsonInclude(NON_NULL)
    private List<TicketDto> tickets;

    @JsonInclude(NON_NULL)
    public Long getFreeSeats() {
        return seats == null ? null : seats.stream().filter(seatDto -> seatDto.getTicket() == null).count();
    }

    public void addTicket(TicketDto ticketDto){
        tickets.add(ticketDto);
    }
}
