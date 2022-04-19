package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.service.SeatService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/seat")
@RequiredArgsConstructor
public class SeatController {

    @NonNull
    private SeatService seatService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SeatDto> getAllMovies() {
        return seatService.findAll();
    }

}
