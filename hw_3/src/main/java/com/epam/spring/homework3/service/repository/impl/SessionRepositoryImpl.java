package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.constants.Constants;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.repository.SessionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
class SessionRepositoryImpl extends CrudRepositoryImpl<Session> implements SessionRepository {
    @Override
    public List<Session> findAllLocalized(String language) {
        return entities.stream()
                .filter(session -> session.getMovie().getLanguage().equals(language))
                .collect(Collectors.toList());
    }

    @Override
    public List<Session> findSessionWithMovie(String movieTitle) {
        return entities.stream()
                .filter(session -> session.getMovie().getTitle().equals(movieTitle))
                .collect(Collectors.toList());
    }

    @Override
    public Session insert(Session session){
        session.setId(UUID.randomUUID().toString());
        createSeats(session);
        entities.add(session);
        return session;
    }

    //populates each session with unique seats, used when new Session is being inserted
    private void createSeats(Session session) {
        List<Seat> seats = new LinkedList<>();

        for (int i = 0; i < Constants.getRows(); i++) {
            for (int j = 0; j < Constants.getSeatsPerRows(); j++) {
                Seat seat = Seat.builder()
                        .row(i + 1)
                        .seatNumber(j + 1)
                        .session(session)
                        .id(UUID.randomUUID().toString())
                        .build();
                seats.add(seat);
            }
        }
        session.setSeats(seats);
    }

    @PostConstruct
    public void init(){

    }
}
