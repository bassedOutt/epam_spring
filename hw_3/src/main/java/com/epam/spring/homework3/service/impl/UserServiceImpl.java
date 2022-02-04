package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.UserMapper;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.repository.UserRepository;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper =UserMapper.INSTANCE;

    @Override
    public List<UserDto> getAll(){
        log.info("getting list of users");
        return repository.getAll().stream().map(mapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto get(Long id) {
        log.info("getting user with id {} ",id);
        return mapper.userToUserDto(repository.get(id));
    }

    @Override
    public void insert(UserDto entity) {
        log.info("inserting user: {}",entity);
        User user = mapper.userDtoToUser(entity);
        repository.insert(user);
    }

    @Override
    public void update(UserDto entity) {
        log.info("updating user: {}",entity);
        User user = mapper.userDtoToUser(entity);
        repository.update(user);
    }

    @Override
    public void delete(UserDto entity) {
        log.info("deleting user: {}",entity);
        User user = mapper.userDtoToUser(entity);
        repository.delete(user);
    }
}
