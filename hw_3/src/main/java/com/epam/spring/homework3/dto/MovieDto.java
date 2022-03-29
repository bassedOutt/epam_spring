package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Session;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class MovieDto implements EntityDto {

    private Long id;

    @Min(value = 10, message = "Movie duration can not be less than 10 min")
    private int duration;

    @NotEmpty(message = "Image url can not be empty")
    private String imageUrl;

    @Min(value = 1, message = "Price can not be 0 or less")
    private int price;

    private String uaTitle;
    private String uaDescription;

    private String enTitle;
    private String enDescription;

    private List<Session> sessionList;

    public String getTitle(String locale) {
        if (locale.equals("en")) {
            return enTitle;
        } else if (locale.equals("ua")) {
            return uaTitle;
        }
        return null;

    }
}
