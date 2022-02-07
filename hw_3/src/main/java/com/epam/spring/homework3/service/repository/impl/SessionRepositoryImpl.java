package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.repository.SessionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SessionRepositoryImpl extends CrudRepositoryImpl<Session> implements SessionRepository {
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
}
