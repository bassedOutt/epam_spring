package com.example.hw_3.dto.mapper;

import com.example.hw_3.dto.SessionDto;
import com.example.hw_3.dto.TicketDto;
import com.example.hw_3.model.Session;
import com.example.hw_3.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);
    SessionDto sessionToSessionDto(Session session);
    Session sessionDtoToSession(SessionDto sessionDto);
}
