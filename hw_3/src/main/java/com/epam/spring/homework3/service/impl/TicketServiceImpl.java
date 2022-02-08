package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.dto.mapper.TicketMapper;
import com.epam.spring.homework3.model.Ticket;
import com.epam.spring.homework3.service.TicketService;
import com.epam.spring.homework3.service.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    private TicketRepository repository;
    private final TicketMapper mapper = TicketMapper.INSTANCE;

    @Autowired
    public void setRepository(TicketRepository repository) {
        this.repository = repository;
    }

    public List<TicketDto> getAll() {
        log.info("getting list of tickets");
        return repository.getAll().stream()
                .map(mapper::ticketToTicketDto)
                .collect(Collectors.toList());
    }

    public TicketDto getById(String id) {
        log.info("getting ticket with id {} ", id);
        return mapper.ticketToTicketDto(repository.getById(id));
    }

    public TicketDto insert(TicketDto entity) {
        log.info("inserting ticket: {}", entity);
        Ticket ticket = mapper.ticketDtoToTicket(entity);
        repository.insert(ticket);
        return entity;
    }

    public TicketDto update(TicketDto entity) {
        log.info("updating ticket with id: {}", entity.getId());
        Ticket ticket = mapper.ticketDtoToTicket(entity);
        repository.update(ticket);
        return entity;
    }

    public void delete(String id) {
        log.info("deleting ticket with id: {}", id);
        repository.delete(id);
    }

}
