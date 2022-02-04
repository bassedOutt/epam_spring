package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto implements EntityDto{
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
}
