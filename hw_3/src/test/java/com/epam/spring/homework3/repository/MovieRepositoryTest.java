package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.Util;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.service.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.constraints.AssertTrue;

@ActiveProfiles("test")
@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private final MovieRepository repository;

    public MovieRepositoryTest(MovieRepository repository) {
        this.repository = repository;
    }

    @Test
    public void ShouldInsertUser(){
        Movie movie = Util.createMovie();

        Movie savedMovie = repository.save(movie);

        System.out.println(savedMovie);
    }
}
