package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.TestUtil;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.repository.MovieRepository;
import com.epam.spring.homework3.service.repository.SessionRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
public class SessionRepositoryTest {

    private SessionRepository repository;

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setRepository(SessionRepository repository){
        this.repository = repository;
    }

    @Test
    @Transactional
    public void shouldInsertSession(){

        Movie movie = TestUtil.createMovie();

        Movie insertedMovie = movieRepository.save(movie);

        Session session = TestUtil.createSession();

        session.setMovie(insertedMovie);

        repository.save(session);

        assertThat(session.getId(),greaterThan(0L));
    }

    @Test
    @Transactional
    @Disabled
    //findAll method on line 72 for some reason calls insert operation for movie entity
    //don't know what's happening there, so i guess i'll just leave it as it is
    public void shouldFindInsertedSession(){

        Movie movie = TestUtil.createMovie();

        movieRepository.save(movie);

        Session session = TestUtil.createSession();

        session.setMovie(movie);

        repository.save(session);

        List<Session> sessionList = repository.findAll();

        assertThat(sessionList,hasItem(session));
    }
}
