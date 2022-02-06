package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.model.User;

public interface UserService extends CrudService<UserDto> {
//    UserDto findByEmailAndPassword(String email, String password);
    UserDto findByEmail(String email);

}
