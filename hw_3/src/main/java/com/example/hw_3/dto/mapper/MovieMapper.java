package com.example.hw_3.dto.mapper;

import com.example.hw_3.dto.MovieDto;
import com.example.hw_3.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    MovieDto movieToMovieDto(Movie movie);
    Movie movieDtoToMovie(MovieDto movieDto);
}
