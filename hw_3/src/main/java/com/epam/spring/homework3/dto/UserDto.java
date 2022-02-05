package com.epam.spring.homework3.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder
public class UserDto implements EntityDto{

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
