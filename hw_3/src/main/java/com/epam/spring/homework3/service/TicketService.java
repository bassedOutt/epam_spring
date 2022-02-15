package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.TicketDto;

import java.util.List;

public interface TicketService {

    List<TicketDto> findAll();

    TicketDto getById(Long id);

    TicketDto insert(TicketDto entity);

    TicketDto update(TicketDto entity);

    void delete(Long id);
}
