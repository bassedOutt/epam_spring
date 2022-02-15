package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.model.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {
    List<UserDto> findAll();

    UserDto getById(Long id);

    UserDto insert(UserDto entity);

    UserDto update(UserDto entity);

    void delete(Long id);

    UserDto findByEmail(String email);
}
