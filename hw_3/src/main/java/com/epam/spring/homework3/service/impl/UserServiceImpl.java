package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.EntityMapper;
import com.epam.spring.homework3.exception.RoleNotFoundException;
import com.epam.spring.homework3.exception.UserNotFoundException;
import com.epam.spring.homework3.model.Role;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.service.repository.RoleRepository;
import com.epam.spring.homework3.service.repository.UserRepository;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final EntityMapper mapper = EntityMapper.INSTANCE;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> findAll() {
        log.info("fetching all users");
        return repository.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        log.info("fetching user with id {} ", id);
        return mapper.toUserDto(repository.getById(id));
    }

    @Override
    public UserDto addRoleToUser(String email, String rolename) {
        log.info("adding role {} to user {}", rolename, email);
        User user = repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        Role role = roleRepository.findByName(rolename).orElseThrow(RoleNotFoundException::new);
        user.addRole(role);
        repository.save(user);
        return mapper.toUserDto(user);
    }

    @Override
    public UserDto insert(UserDto entity) {
        log.info("saving user {} to database", entity.getEmail());
        User user = mapper.fromUserDto(entity);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toUserDto(repository.save(user));
    }

    @Override
    public UserDto update(UserDto entity) {
        log.info("updating user: {}", entity.getEmail());
        User user = mapper.fromUserDto(entity);
        repository.save(user);
        return entity;
    }

    @Override
    public void delete(Long id) {
        log.info("deleting user with an id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        log.info("Searching for user with email: {}", email);
        UserDto userDto = mapper.toUserDto(repository.findByEmail(email).orElseThrow(UserNotFoundException::new));
        log.info("User found: {}", userDto);
        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with email %s not found", s)));

        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), authorities);
    }
}
