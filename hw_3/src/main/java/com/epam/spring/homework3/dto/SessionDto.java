package com.epam.spring.homework3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SessionDto implements EntityDto {

    public SessionDto() {

    }

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "movie can not be null")
    private MovieDto movie;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @NotNull(message = "start time can not be null")
    private LocalDateTime startTime;

    private PricingDto pricing;

    private List<SeatDto> seats;

    public Long getFreeSeats(){
        return seats.stream().filter(seatDto -> seatDto.getTicket()==null).count();
    }
}
