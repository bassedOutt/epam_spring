package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.EntityMapper;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.service.repository.UserRepository;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private UserRepository repository;
    private final EntityMapper mapper = EntityMapper.INSTANCE;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> findAll() {
        log.info("getting list of users");
        return repository.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        log.info("getting user with id {} ", id);
        return mapper.toUserDto(repository.getById(id));
    }

    public UserDto insert(UserDto entity) {
        log.info("inserting user: {}", entity);
        User user = mapper.fromUserDto(entity);
        return mapper.toUserDto(repository.save(user));
    }

    public UserDto update(UserDto entity) {
        log.info("updating user: {}", entity);
        User user = mapper.fromUserDto(entity);
        repository.save(user);
        return entity;
    }

    public void delete(Long id) {
        log.info("deleting user with an id: {}", id);
        repository.deleteById(id);
    }

    public UserDto findByEmail(String email) {
        log.info("Searching for user with email: {}", email);
        UserDto userDto = mapper.toUserDto(repository.findByEmail(email));
        log.info("User found: {}",userDto);
        return userDto;
    }

}
