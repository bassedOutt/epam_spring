package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.constants.Constants;
import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.epam.spring.homework3.constants.Constants.ROLES.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(OK)
    public UserDto findAll(){
        return null;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserDto createUser(@RequestBody @Valid UserDto user){
        userService.insert(user);
        return userService.addRoleToUser(user.getEmail(), ROLE_USER.toString());
    }

    @PostMapping("/add_role_to_user")
    public UserDto addRoleToUser(@RequestBody String email, String role){
        return userService.addRoleToUser(email, role);
    }
}
