package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserDto> getAllUsers(){
        log.info("getting list of users");
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{email}")
    public UserDto getUser(@PathVariable String email){
        log.info("getting user by email: {}",email);
        return userService.findByEmail(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto insertUser(@RequestBody @Valid UserDto userDto){
        log.info("creating user : {}",userDto);
        return userService.insert(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public UserDto updateUser(@RequestBody @Valid UserDto userDto){
        log.info("updating user : {}",userDto);
        return userService.update(userDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        log.info("deleting user with id: {}",id);
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
