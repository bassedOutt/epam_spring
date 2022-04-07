package com.epam.spring.homework3;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.dto.mapper.MovieMapper;
import com.epam.spring.homework3.dto.mapper.SessionMapper;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.Session;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

public class Util {

    private static final MovieMapper MOVIE_MAPPER = Mappers.getMapper(MovieMapper.class);

    private static final SessionMapper SESSION_MAPPER = Mappers.getMapper(SessionMapper.class);


    public static Movie createMovie(){
        Movie movie = new Movie();
        movie.setDuration(156);
        movie.setEnDescription("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
        movie.setEnTitle("Pulp Fiction");
        movie.setImageUrl("https://upload.wikimedia.org/wikipedia/uk/0/06/Pulp_Fiction_%28Soundtrack%29.png");
        movie.setPrice(135);
        movie.setUaDescription("Життя двох вбивць, бокaсера, гангстера та його дружини, а також пари бандитів із закусочної переплітаються в чотирьох казках про насильство та спокуту.");
        movie.setUaTitle("Кримінальне чтиво");
        return movie;
    }

    public static MovieDto createMovieDto(){
        return MOVIE_MAPPER.movieToMovieDto(createMovie());
    }

    public static Session createSession(){
        Session session = new Session();
        session.setStartTime(LocalDateTime.now());
        return session;
    }


    public static SessionDto createSessionDto(){
        return SESSION_MAPPER.sessionToSessionDto(createSession());
    }


}
