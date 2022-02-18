package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.mapper.MovieMapper;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.service.LanguageService;
import com.epam.spring.homework3.service.repository.MovieRepository;
import com.epam.spring.homework3.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
class MovieServiceImpl implements MovieService {

    private MovieRepository repository;
    private final MovieMapper mapper = MovieMapper.INSTANCE;

    @Autowired
    public void setRepository(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MovieDto> getAll() {
        log.info("getting all movies");
        return repository.findAll().stream()
                .map(mapper::movieToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDto getById(Long id) {
        log.info("Searching for movie with id: {}", id);
        return mapper.movieToMovieDto(repository.getById(id));
    }

    @Override
    public MovieDto insert(MovieDto entity) {
        log.info("Inserting movie :{}", entity);
        MovieDto insertedMovie = mapper.movieToMovieDto(repository.save(mapper.movieDtoToMovie(entity)));
        log.info("Movie was inserted");
        return insertedMovie;
    }

    @Override
    public MovieDto update(MovieDto entity) {
        log.info("updating movie: {}", entity);
        Movie movie = mapper.movieDtoToMovie(entity);
        repository.save(movie);
        return entity;
    }

    @Override
    public void delete(Long id) {
        log.info("deleting movie with an id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public MovieDto findByTitle(String title) {
        log.info("Searching for movie with title:{}", title);
        String locale = LanguageService.getUserLanguage();
        MovieDto movieDto = null;
        if (locale.equals("en")) {
            movieDto = mapper.movieToMovieDto(repository.findMovieByEnTitle(title));
        } else if (locale.equals("ua")) {
            movieDto = mapper.movieToMovieDto(repository.findMovieByUaTitle(title));
        }
        log.info("movie found:{}", movieDto);
        return movieDto;
    }
}
