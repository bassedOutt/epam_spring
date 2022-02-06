package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.service.MovieService;
import com.epam.spring.homework3.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@Slf4j
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setUserService(MovieService movieService) {
        this.movieService = movieService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<MovieDto> getAllMovies() {
        log.info("getting list of movies");
        return movieService.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{title}")
    public MovieDto getMovie(@PathVariable String title) {
        log.info("getting movie by title: {}", title);
        return movieService.findByTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieDto insertMovie(@RequestBody MovieDto movieDto) {
        log.info("creating movie : {}", movieDto);
        return movieService.insert(movieDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        log.info("updating movie : {}", movieDto);
        return movieService.update(movieDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public ResponseEntity<Void> deleteMovie(@RequestBody MovieDto movieDto) {
        log.info("deleting movie : {}", movieDto);
        movieService.delete(movieDto);
        return ResponseEntity.noContent().build();
    }
}
