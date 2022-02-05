package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class User implements Entity {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean isAdmin;
    private static long nextId = 0;

    public static Long getNextId() {
        return ++nextId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
