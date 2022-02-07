package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.model.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie>{
    List<Movie> findAllLocal(String language);
    Movie findByTitle(String movieName);
}
