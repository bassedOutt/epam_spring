package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    SeatDto seatToSeatDto(Seat seat);

    Seat seatDtoToSeat(SeatDto seatDto);
}
