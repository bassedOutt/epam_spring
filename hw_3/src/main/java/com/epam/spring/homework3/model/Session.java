package com.epam.spring.homework3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
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

    @JsonManagedReference
    @OneToMany(mappedBy = "session",orphanRemoval = true)
    private List<Seat> seats;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
