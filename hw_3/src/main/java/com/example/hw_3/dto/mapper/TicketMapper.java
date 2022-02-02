package com.example.hw_3.dto.mapper;

import com.example.hw_3.dto.TicketDto;
import com.example.hw_3.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);
    TicketDto ticketToTicketDto(Ticket ticket);
    Ticket ticketDtoToTicket(TicketDto ticketDto);
}
