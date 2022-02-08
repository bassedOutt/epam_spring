package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.dto.mapper.SeatMapper;
import com.epam.spring.homework3.dto.mapper.TicketMapper;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Ticket;
import com.epam.spring.homework3.service.SeatService;
import com.epam.spring.homework3.service.TicketService;
import com.epam.spring.homework3.service.repository.SeatRepository;
import com.epam.spring.homework3.service.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SeatServiceImpl implements SeatService {

    private SeatRepository repository;
    private final SeatMapper mapper = SeatMapper.INSTANCE;

    @Autowired
    public void setRepository(SeatRepository repository) {
        this.repository = repository;
    }

    public List<SeatDto> getAll() {
        log.info("getting list of seats");
        return repository.getAll().stream()
                .map(mapper::seatToSeatDto)
                .collect(Collectors.toList());
    }

    public SeatDto getById(String id) {
        log.info("getting seat with id {} ", id);
        return mapper.seatToSeatDto(repository.getById(id));
    }

    public SeatDto insert(SeatDto entity) {
        log.info("inserting seat: {}", entity);
        Seat seat = mapper.seatDtoToSeat(entity);
        repository.insert(seat);
        return entity;
    }

    public SeatDto update(SeatDto entity) {
        log.info("updating seat with id: {}", entity.getId());
        Seat seat = mapper.seatDtoToSeat(entity);
        repository.update(seat);
        return entity;
    }

    public void delete(String id) {
        log.info("deleting seat with id: {}", id);
        repository.delete(id);
    }

}
