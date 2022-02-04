package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Entity {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
    private static long nextId=0;

    public static Long getNextId(){
        return ++nextId;
    }
}
