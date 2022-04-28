package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);
    TicketDto ticketToTicketDto(Ticket ticket);
    Ticket ticketDtoToTicket(TicketDto ticketDto);
}
