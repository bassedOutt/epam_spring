package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@Builder
@Entity
public class Session{

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

    @OneToMany(mappedBy = "session",orphanRemoval = true)
    private List<Seat> seats;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
