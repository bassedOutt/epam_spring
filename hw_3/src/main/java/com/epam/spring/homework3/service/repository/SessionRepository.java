package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.model.Session;

import java.util.List;

public interface SessionRepository extends CrudRepository<Session>{
    List<Session> findAllLocalized(String language);
    List<Session> findSessionWithMovie(String movieTitle);
}
