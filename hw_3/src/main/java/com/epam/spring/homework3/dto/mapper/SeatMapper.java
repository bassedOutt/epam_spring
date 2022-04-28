package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
    SeatDto seatToSeatDto(Seat seat);
    Seat seatDtoToSeat(SeatDto seatDto);
}
