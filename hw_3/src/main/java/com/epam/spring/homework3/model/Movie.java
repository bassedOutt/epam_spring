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

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int price;
    private Date releaseDate;

    @Column(unique = true)
    private String uaTitle;
    private String uaDescription;

    @Column(unique = true,nullable = false)
    private String enTitle;
    private String enDescription;

    @OneToMany(mappedBy = "movie",orphanRemoval = true)
    private List<Session> sessionList;

}
