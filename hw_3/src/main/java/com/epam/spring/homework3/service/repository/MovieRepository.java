package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    Movie findMovieByEnTitle(String title);
    Movie findMovieByUaTitle(String title);

}
