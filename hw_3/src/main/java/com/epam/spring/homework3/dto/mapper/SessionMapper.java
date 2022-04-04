package com.epam.spring.homework3.dto.mapper;

import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.PricingDto;
import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.Pricing;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    MovieMapper MOVIE_MAPPER_INSTANCE = Mappers.getMapper(MovieMapper.class);

    Session sessionDtoToSession(SessionDto sessionDto);

    //One to many relation with movie and session ends up in stack overflow, so I need custom mappers for these 2
    default SessionDto sessionToSessionDto(Session session){
        session.getMovie().setSessionList(null);
        return sessionToSessionDtoAllFields(session);
    }

    default SessionDto sessionToSessionDtoAllFields(Session session){
        if ( session == null ) {
            return null;
        }

        SessionDto.SessionDtoBuilder sessionDto = SessionDto.builder();

        sessionDto.id( session.getId() );
        sessionDto.movie(MOVIE_MAPPER_INSTANCE.movieToMovieDto(session.getMovie()) );
        sessionDto.startTime( session.getStartTime() );
        sessionDto.endTime( session.getEndTime() );
        sessionDto.date( session.getDate() );
        sessionDto.pricing( pricingToPricingDto( session.getPricing() ) );
        sessionDto.seats( seatListToSeatDtoList( session.getSeats() ) );

        return sessionDto.build();
    }

    PricingDto pricingToPricingDto(Pricing pricing);
    List<SeatDto> seatListToSeatDtoList(List<Seat> seats);
}
