package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.UserDto;

public interface UserService extends CrudService<UserDto>{
    UserDto findByEmail(String email);
    UserDto findById(Long id);

    UserDto addRoleToUser(String email, String rolename);
}
