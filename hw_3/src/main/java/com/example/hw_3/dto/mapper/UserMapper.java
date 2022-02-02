package com.example.hw_3.dto.mapper;

import com.example.hw_3.dto.UserDto;
import com.example.hw_3.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
