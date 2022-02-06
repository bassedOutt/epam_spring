package com.epam.spring.homework3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User implements Entity {

    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
}
