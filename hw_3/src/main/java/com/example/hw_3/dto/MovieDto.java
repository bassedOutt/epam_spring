package com.example.hw_3.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class MovieDto {

    private int id;
    private int duration;
    private String imageUrl;
    private int price;
    private Date startDate;
    private String title;
    private String description;
    private String language;

}
