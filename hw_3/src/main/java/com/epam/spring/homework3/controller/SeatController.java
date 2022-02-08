package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.service.SeatService;
import com.epam.spring.homework3.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/seat")
public class SeatController {

    private SeatService service;

    @Autowired
    public void setUserService(SeatService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SeatDto> getAllSeats(){
        log.info("getting list of seats");
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SeatDto createTicket(@RequestBody SeatDto seatDto){
        log.info("creating seat : {}",seatDto);
        return service.insert(seatDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public SeatDto updateTicket(@RequestBody SeatDto seatDto){
        log.info("updating seat with id : {}",seatDto.getId());
        return service.update(seatDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id){
        log.info("deleting seat with an id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
