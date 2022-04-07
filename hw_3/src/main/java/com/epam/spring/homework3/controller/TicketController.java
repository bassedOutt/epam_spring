package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<TicketDto> getAllTicket(){
        log.info("getting list of tickets");
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id){
        log.info("deleting ticket with id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
