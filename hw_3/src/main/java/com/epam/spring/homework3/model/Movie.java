package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class Movie implements Entity {

    private String id;
    private int duration;
    private String imageUrl;
    private int price;
    private Date startDate;
    private String title;
    private String description;
    private String language;
}
