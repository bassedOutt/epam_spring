package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.MovieDto;

import java.util.List;

public interface MovieService extends CrudService<MovieDto> {
    List<MovieDto> findLocalMovies(String language);

    MovieDto findByTitle(String title);

}
