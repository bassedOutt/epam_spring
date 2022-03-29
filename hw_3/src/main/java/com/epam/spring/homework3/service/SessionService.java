package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.SessionDto;

import java.util.List;

public interface SessionService extends CrudService<SessionDto> {

    //sorts list of sessions(by name, time or number of available seats)
    List<SessionDto> sortSessions(String sorter, List<SessionDto> sessions);

    //returns list of sessions in some range(today, tomorrow, this week)
    List<SessionDto> findInRange(String range, List<SessionDto> sessions);

    //ensures that the newly created session's show time does not interfere with other sessions
    boolean noTimeOverlap(SessionDto s);

    List<SessionDto> findSessionsWithTitle(String title);

    void insertSeats(SessionDto session);

}
