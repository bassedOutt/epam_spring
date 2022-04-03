package com.epam.spring.homework3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SessionDto implements EntityDto {

    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "movie can not be null")
    private MovieDto movie;

    @NotNull(message = "start time can not be null")
    private Time startTime;

    @NotNull(message = "end time can not be null")
    private Time endTime;

    @NotNull(message = "date can not be null")
    private Date date;

    private PricingDto pricing;

    private List<SeatDto> seats;

}
