package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.service.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public SeatDto createSeat(@RequestBody @Valid SeatDto seatDto){
        log.info("creating seat : {}",seatDto);
        return service.insert(seatDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public SeatDto updateSeat(@RequestBody @Valid SeatDto seatDto){
        log.info("updating seat with id : {}",seatDto.getId());
        return service.update(seatDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable String id){
        log.info("deleting seat with id: {}",id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
