package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.TestUtil;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.service.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class MovieRepositoryTest {

    private MovieRepository repository;

    @Autowired
    public void setRepository(MovieRepository movieRepository) {
        this.repository = movieRepository;
    }

    @Test
    @Transactional
    public void ShouldInsertUser(){
        Movie movie = TestUtil.createMovie();

        Movie savedMovie = repository.save(movie);

        assertThat(savedMovie.getId(), greaterThan(0L));
    }

    @Test
    public void shouldFindAllMovies(){
        List<Movie> movieList = repository.findAll();

        assertThat(movieList.size(), greaterThan(0));
    }

    @Test
    @Transactional
    public void shouldUpdateMovie(){


        Movie movie = repository.findMovieByEnTitle("Fight Club").get();

        movie.setEnDescription("Fight club edited");

        Movie updatedMovie = repository.save(movie);

        assertThat(updatedMovie,
                hasProperty("enDescription",equalTo("Fight club edited")));
    }

    @Test
    @Transactional
    public void shouldDeleteMovie(){

        Movie movie = repository.findMovieByEnTitle("Fight Club").get();

        repository.delete(movie);

        Optional<Movie> deletedMovie = repository.findMovieByEnTitle("Fight club");

        assertThat(deletedMovie.isPresent(),equalTo(false));

    }

}
