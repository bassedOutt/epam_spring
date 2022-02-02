package com.example.hw_3.dto.mapper;

import com.example.hw_3.dto.SeatDto;
import com.example.hw_3.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeatMapper {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);
    SeatDto seatToSeatDto(Seat seat);
    Seat seatDtoToSeat(SeatDto seatDto);
}
