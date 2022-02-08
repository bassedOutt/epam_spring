package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.PricingDto;
import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.service.PricingService;
import com.epam.spring.homework3.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/ticket")
public class TicketController {

    private TicketService service;

    @Autowired
    public void setUserService(TicketService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<TicketDto> getAllPricings(){
        log.info("getting list of tickets");
        return service.getAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TicketDto createTicket(@RequestBody TicketDto ticketDto){
        log.info("creating ticket : {}",ticketDto);
        return service.insert(ticketDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public TicketDto updateTicket(@RequestBody TicketDto ticketDto){
        log.info("updating ticket with id : {}",ticketDto.getId());
        return service.update(ticketDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable String id){
        log.info("deleting ticket with an id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
