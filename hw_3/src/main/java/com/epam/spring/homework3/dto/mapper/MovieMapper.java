package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDto movieToMovieDto(Movie movie);

    Movie movieDtoToMovie(MovieDto movieDto);
}
