package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDto implements EntityDto{
    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;

}
