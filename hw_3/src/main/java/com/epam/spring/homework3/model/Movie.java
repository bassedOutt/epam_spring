package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Movie implements Entity {

    private Long id;
    private int duration;
    private String imageUrl;
    private int price;
    private Date startDate;
    private String title;
    private String description;
    private String language;
    private static long nextId=0;
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
