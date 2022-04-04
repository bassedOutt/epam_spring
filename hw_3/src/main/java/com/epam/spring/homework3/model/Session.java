package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@ToString(exclude = {"movie"})
@Entity
public class Session{

    public Session(){}

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "pricing_id")
    private Pricing pricing;

    @OneToMany
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private List<Seat> seats;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


}
