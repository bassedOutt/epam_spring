package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.exception.EntityNotFoundException;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.service.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
class MovieRepositoryImpl extends CrudRepositoryImpl<Movie> implements MovieRepository {
    @Override
    public List<Movie> findAllLocal(String language) {
        return entities.stream()
                .filter(movie -> movie.getLanguage().equals(language))
                .collect(Collectors.toList());
    }

    @Override
    public Movie findByTitle(String movieName) {
        return entities.stream()
                .filter(movie -> movie.getTitle().equals(movieName))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("no movie with title " + movieName));
    }

    @PostConstruct
    public void init() {
        Movie movie = Movie.builder()
                .language("en")
                .id(UUID.randomUUID().toString())
                .description("Between 1968 and 1983, a San Francisco cartoonist becomes an amateur detective obsessed with tracking down the Zodiac Killer, an unidentified individual who terrorizes Northern California with a killing spree")
                .imageUrl("https://m.media-amazon.com/images/I/41xApuX9fML._SY445_.jpg")
                .duration(157)
                .price(145)
                .title("Zodiac")
                .build();


        Movie movie2 = Movie.builder()
                .language("en")
                .id(UUID.randomUUID().toString())
                .description("An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.")
                .imageUrl("https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg")
                .duration(139)
                .price(132)
                .title("Fight Club")
                .build();

        entities.addAll(List.of(movie, movie2));

    }

}
