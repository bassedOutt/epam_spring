package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.UserMapper;
import com.epam.spring.homework3.exception.EntityCreationException;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
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
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDto> getAll() {
        log.info("getting list of users");
        return repository.getAll().stream().map(mapper::userToUserDto).collect(Collectors.toList());
    }

    public UserDto getById(String id) {
        log.info("getting user with id {} ", id);
        return mapper.userToUserDto(repository.getById(id));
    }

    public UserDto insert(UserDto entity) {
        log.info("inserting user: {}", entity);

        User user = mapper.userDtoToUser(entity);
        repository.insert(user);
        return entity;
    }

    public UserDto update(UserDto entity) {
        log.info("updating user: {}", entity);
        User user = mapper.userDtoToUser(entity);
        repository.update(user);
        return entity;
    }

    public void delete(UserDto userDto) {
        log.info("deleting user: {}", userDto);
        User user = mapper.userDtoToUser(userDto);
        repository.delete(user);
    }

//    public UserDto findByEmailAndPassword(String email, String password) {
//        log.info("Searching for user. Email: {}, Password:{}", email, password);
//        User user = repository.findByEmailAndPassword(email, password);
//        if (user == null) {
//            throw new EntityCreationException("User with such credentials does not exist");
//        }
//        return mapper.userToUserDto(user);
//    }

    public UserDto findByEmail(String email) {
        log.info("Searching for user with email: {}", email);
        UserDto userDto = mapper.userToUserDto(repository.findByEmail(email));
        log.info("User found: {}",userDto);
        return userDto;
    }

}
