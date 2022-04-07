package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.mapper.SeatMapper;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.service.SeatService;
import com.epam.spring.homework3.service.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
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

    @Override
    public List<SeatDto> findAll() {
        log.info("getting list of seats");
        return repository.findAll().stream()
                .map(mapper::seatToSeatDto)
                .collect(Collectors.toList());
    }


    @Override
    public SeatDto insert(SeatDto entity) {
        log.info("inserting seat: {}", entity);
        Seat seat = mapper.seatDtoToSeat(entity);
        repository.save(seat);
        return entity;
    }

    @Override
    public SeatDto update(SeatDto entity) {
        log.info("updating seat with id: {}", entity.getId());
        Seat seat = mapper.seatDtoToSeat(entity);
        repository.save(seat);
        return entity;
    }

    @Override
    public void delete(Long id) {
        log.info("deleting seat with id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public SeatDto findById(Long id) {
        Optional<Seat> seat = repository.findById(id);
        if (seat.isPresent()) {
            return mapper.seatToSeatDto(seat.get());
        }
        throw new EntityNotFoundException("No seat with id " + id);
    }
}
