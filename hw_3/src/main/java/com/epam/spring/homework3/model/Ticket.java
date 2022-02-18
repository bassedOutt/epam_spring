package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;


/*I could go for 2 entities (seat and ticket), as conceptually those are 2
 different things and then just use oneToOne relationship,
 but decided to stick with just one as they do correlate quite a lot
 and the actual ticket will need all of the seat's fields, except the one that indicates if its taken,
 so in the end if I had 2 entities it will just result in unnecessary selects. */

@Data
@Builder
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private double price;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Seat> seat;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
