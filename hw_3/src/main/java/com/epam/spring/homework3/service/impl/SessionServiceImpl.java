package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.dto.mapper.SessionMapper;
import com.epam.spring.homework3.exception.EntityCreationException;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.repository.SessionRepository;
import com.epam.spring.homework3.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
class SessionServiceImpl implements SessionService {

    private SessionRepository repository;
    private final SessionMapper mapper = SessionMapper.INSTANCE;

    @Autowired
    public void setRepository(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SessionDto> getAll() {
        return repository.getAll()
                .stream().map(mapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public SessionDto getById(String id) {
        log.info("getting session with id {} ", id);
        return mapper.sessionToSessionDto(repository.getById(id));
    }

    public SessionDto insert(SessionDto sessionDto) {
        log.info("inserting session: {}", sessionDto);
        if (!noTimeOverlap(sessionDto)) {
            throw new EntityCreationException("There are already movie session going in that time");
        } else {
            Session session = mapper.sessionDtoToSession(sessionDto);
            repository.insert(session);
            return sessionDto;
        }
    }

    public SessionDto update(SessionDto sessionDto) {
        log.info("updating session: {}", sessionDto);
        Session session = mapper.sessionDtoToSession(sessionDto);
        repository.update(session);
        return sessionDto;
    }

    public void delete(String id) {
        log.info("deleting session with id: {}", id);
        repository.delete(id);
    }

    public List<SessionDto> sortSessions(String sorter, List<SessionDto> sessions) {
        switch (sorter) {
            case "name":
                return sessions.stream().sorted(byName).collect(Collectors.toList());
            case "time": {
                return sessions.stream().sorted(byTime).collect(Collectors.toList());
            }
            case "seats": {
                return sessions.stream().sorted(bySeats.reversed()).collect(Collectors.toList());
            }
        }
        return sessions;
    }

    public List<SessionDto> findAllLocalized(String language) {
        log.info("Getting all localized sessions. Language: {}", language);
        return repository.findAllLocalized(language)
                .stream().map(mapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SessionDto> findSessionsWithTitle(String title) {
        log.info("Finding sessions with title: {}", title);
        return repository.findSessionWithMovie(title)
                .stream().map(mapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public List<SessionDto> findInRange(String filter, List<SessionDto> sessions) {

        Date end = Date.valueOf(LocalDate.now());
        Date begin = Date.valueOf(LocalDate.now());

        switch (filter) {

            case "today":
                break;
            case "tomorrow": {
                begin = addDays(end, 1);
                end = addDays(end, 1);
                break;
            }
            case "week": {
                end = addDays(end, 7);
                break;
            }
            default:
                return sessions;
        }

        final Date begin1 = begin;
        final Date end1 = end;

        log.info("filtering sessions in range: {}", filter);
        return sessions.stream().filter(session -> !(session.getDate().before(begin1)) && !(session.getDate().after(end1))).collect(Collectors.toList());
    }

    private Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }

    public boolean noTimeOverlap(SessionDto s) {
        List<SessionDto> sessions = this.getAll().stream()
                .filter(session1 -> session1.getDate().equals(s.getDate()))
                .filter(session -> !session.getId().equals(s.getId()))
                .collect(Collectors.toList());
        return sessions.stream()
                .allMatch(s1 -> !(s1.getStartTime().after(s.getStartTime())
                        && s1.getEndTime().before(s.getStartTime()))
                        && !(s1.getStartTime().before(s.getEndTime())
                        && s1.getEndTime().after(s.getEndTime()))
                        && s1.getStartTime().compareTo(s.getStartTime()) != 0 && s1.getEndTime().compareTo(s.getEndTime()) != 0);
    }


    private final Comparator<SessionDto> byName = Comparator.comparing((SessionDto s) -> s.getMovie().getTitle());
    private final Comparator<SessionDto> byTime = (SessionDto s1, SessionDto s2) ->
            s1.getDate().compareTo(s2.getDate()) == 0 ? s1.getStartTime().compareTo(s2.getStartTime()) : s1.getDate().compareTo(s2.getDate());

    private final Comparator<SessionDto> bySeats = Comparator.comparing(SessionDto::getFreeSeats);
}
