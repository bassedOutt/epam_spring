package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.model.User;

import java.util.List;

public interface UserService extends CrudService<UserDto>{
    UserDto findByEmail(String email);
    UserDto findById(Long id);

    void addRoleToUser(String email,String rolename);
}
