package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private int duration;
    private String imageUrl;
    private int price;
    private Date releaseDate;

    private String uaTitle;
    private String uaDescription;

    private String enTitle;
    private String enDescription;

    @OneToMany(mappedBy = "movie")
    private List<Session> sessionList;

}
