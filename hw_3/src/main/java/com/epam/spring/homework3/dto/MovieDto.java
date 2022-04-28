package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class MovieDto implements EntityDto{

    private String id;
    private int duration;
    private String imageUrl;
    private int price;
    private Date startDate;
    private String title;
    private String description;
    private String language;

}
