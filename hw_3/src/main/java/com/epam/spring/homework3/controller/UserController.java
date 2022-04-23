package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController("api/v1/user")
public class UserController {
    private UserService userService;

    @GetMapping
    @ResponseStatus(OK)
    public UserDto findAll(){
        return null;
    }
}
