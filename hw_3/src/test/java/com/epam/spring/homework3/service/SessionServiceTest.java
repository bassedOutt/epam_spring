package com.epam.spring.homework3.service;

import com.epam.spring.homework3.Util;
import com.epam.spring.homework3.dto.MovieDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.model.Movie;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.impl.SessionServiceImpl;
import com.epam.spring.homework3.service.repository.SessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.epam.spring.homework3.service.SessionService.SESSION_SORTERS.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class SessionServiceTest {

    @Spy
    private SessionRepository repository;

    @InjectMocks
    private SessionServiceImpl service;

    @Test
    public void shouldInsertSession(){

        SessionDto sessionDto = Util.createSessionDto();

        Session testSession = Util.createSession();

        testSession.setId(1L);

        when(repository.save(Mockito.any(Session.class))).thenReturn(testSession);

        SessionDto savedSessionDto = service.insert(sessionDto);

        assertThat(savedSessionDto.getId(),greaterThan(0L));
    }

    @Test
    public void shouldSortSessionsByTime(){

        SessionDto session1 = new SessionDto();
        session1.setStartTime(LocalDateTime.now());

        MovieDto movie1 = new MovieDto();
        movie1.setEnTitle("A");
        session1.setMovie(movie1);

        SessionDto session2 = new SessionDto();
        session2.setStartTime(LocalDateTime.now().plusHours(5));

        MovieDto movie2 = new MovieDto();
        movie1.setEnTitle("C");
        session2.setMovie(movie2);

        SessionDto session3 = new SessionDto();
        session3.setStartTime(LocalDateTime.now().plusHours(2));

        MovieDto movie3 = new MovieDto();
        movie3.setEnTitle("B");
        session3.setMovie(movie3);

        List<SessionDto> sessions = List.of(session1,session3,session2);

        List<SessionDto> sessionsSortedByTime = service
                .sortSessions(BY_TIME.toString(), sessions);

        assertThat(sessionsSortedByTime,contains(session1,session3,session2));

        List<SessionDto> sessionSortedByName = service
                .sortSessions(BY_NAME.toString(), sessions);

        assertThat(sessionSortedByName,contains(session1,session3,session2));
    }


}
