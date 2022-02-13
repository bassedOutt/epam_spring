package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping("/all/{language}")
    public List<MovieDto> getAllMovies(@PathVariable String language) {
        log.info("getting list of movies, language:{}",language);
        return movieService.findLocalMovies(language);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}")
    public MovieDto getMovie(@PathVariable String id) {
        log.info("getting movie by id: {}", id);
        return movieService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public MovieDto getMovieByTitle(@RequestParam String title) {
        log.info("getting movie by title: {}", title);
        return movieService.findByTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MovieDto insertMovie(@RequestBody @Valid MovieDto movieDto) {
        log.info("creating movie : {}", movieDto);
        return movieService.insert(movieDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public MovieDto updateMovie(@RequestBody @Valid MovieDto movieDto) {
        log.info("updating movie : {}", movieDto);
        return movieService.update(movieDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        log.info("deleting movie with id: {}", id);
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
