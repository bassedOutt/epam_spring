package com.epam.spring.homework3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class MovieDto implements EntityDto{

    private String id;

    @Min(value = 10, message = "Movie duration can not be less than 10 min")
    private int duration;

    @NotEmpty(message = "Image url can not be empty")
    private String imageUrl;

    @Min(value = 1,message = "Price can not be 0 or less")
    private int price;

    private Date startDate;

    @NotEmpty(message = "Movie title can not be empty")
    private String title;

    @NotEmpty(message = "Movie description can not be empty")
    private String description;

    @NotEmpty(message = "Language can not be empty")
    private String language;

}
