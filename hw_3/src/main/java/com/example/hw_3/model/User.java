package com.example.hw_3.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User implements Entity {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
}
