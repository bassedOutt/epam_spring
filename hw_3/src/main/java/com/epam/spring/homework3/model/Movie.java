package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class Movie {

    public Movie(){}

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @Column(unique = true)
    private String uaTitle;
    private String uaDescription;

    @Column(unique = true,nullable = false)
    private String enTitle;
    private String enDescription;

    @JsonManagedReference
    @OneToMany(mappedBy = "movie")
    private List<Session> sessionList;
}
