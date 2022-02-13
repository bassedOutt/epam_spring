package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
public class UserDto implements EntityDto{

    private String id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @Email
    private String email;

    @NotEmpty
    @Min(6)
    @Max(30)
    private String password;

    private boolean isAdmin;
}
