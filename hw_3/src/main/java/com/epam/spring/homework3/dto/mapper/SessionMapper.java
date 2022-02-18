package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);
    SessionDto sessionToSessionDto(Session session);
    Session sessionDtoToSession(SessionDto sessionDto);

    SeatDto seatToSeatDto(Seat seat);
}
