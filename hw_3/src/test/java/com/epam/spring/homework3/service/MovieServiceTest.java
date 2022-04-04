package com.epam.spring.homework3.service;

import com.epam.spring.homework3.Util;
import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.exception.EntityNotFoundException;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.service.impl.MovieServiceImpl;
import com.epam.spring.homework3.service.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    private final String TEST_MOVIE_NAME_EN = "Pulp Fiction";

    private final String TEST_MOVIE_NAME_UA = "Кримінальне чтиво";

    @Test
    public void shouldFindMovieByEnTitle(){

        Movie movie  = Util.createMovie();

        when(movieRepository.findMovieByEnTitle(TEST_MOVIE_NAME_EN)).thenReturn(Optional.of(movie));

        MovieDto movieDto = movieService.findByTitle(TEST_MOVIE_NAME_EN);

        assertThat(movieDto,allOf(
                hasProperty("enTitle",equalTo(TEST_MOVIE_NAME_EN)),
                hasProperty("uaTitle",equalTo(TEST_MOVIE_NAME_UA))
        ));
    }

    @Test
    public void shouldFindMovieByUaTitle(){

        Movie movie  = Util.createMovie();

        when(movieRepository.findMovieByUaTitle(TEST_MOVIE_NAME_UA)).thenReturn(Optional.of(movie));

        MovieDto movieDto = movieService.findByTitle(TEST_MOVIE_NAME_UA);

        assertThat(movieDto,allOf(
                hasProperty("enTitle",equalTo(TEST_MOVIE_NAME_EN)),
                hasProperty("uaTitle",equalTo(TEST_MOVIE_NAME_UA))
        ));
    }

    @Test
    public void shouldCreateMovie(){

        MovieDto movieDto = Util.createMovieDto();

        Movie testMovie = Util.createMovie();

        when(movieRepository.save(Mockito.any(Movie.class))).thenReturn(testMovie);

        MovieDto savedMovieDto = movieService.insert(movieDto);

        assertThat(savedMovieDto,equalTo(movieDto));
    }

    @Test
    public void shouldThrowEntityNotFoundException(){

        MovieDto movieDto = Util.createMovieDto();

        Exception exception = assertThrows(EntityNotFoundException.class,()->
                movieService.update(movieDto));

        final String EXPECTED_MESSAGE = "Movie is not present in the database";

        assertThat(exception.getMessage(),equalTo(EXPECTED_MESSAGE));
    }
}
