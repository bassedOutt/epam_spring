package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;


@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    SessionMapper SESSION_MAPPER = Mappers.getMapper(SessionMapper.class);

    @Named("movieToMovieDto")
    MovieDto movieToMovieDto(Movie movie);

    Movie movieDtoToMovie(MovieDto movieDto);

    default SessionDto sessionToSessionDto(Session session){
        session.setMovie(null);
        return SESSION_MAPPER.sessionToSessionDtoAllFields(session);
    }


}
