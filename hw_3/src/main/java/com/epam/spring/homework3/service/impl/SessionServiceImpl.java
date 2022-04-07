package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.SessionMapper;
import com.epam.spring.homework3.exception.SeatIsAlreadyTakenException;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.SeatService;
import com.epam.spring.homework3.service.TicketService;
import com.epam.spring.homework3.service.repository.SessionRepository;
import com.epam.spring.homework3.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class SessionServiceImpl implements SessionService {

    private SessionRepository repository;
    private final SessionMapper mapper = SessionMapper.INSTANCE;

    @Autowired
    public void setRepository(SessionRepository repository) {
        this.repository = repository;
    }

    private TicketService ticketService;
    private SeatService seatService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Autowired
    public void setSeatService(SeatService seatService) {
        this.seatService = seatService;
    }

    @Override
    public List<SessionDto> findAll() {
        List<Session> sessions = repository.findAll();
        return sessions
                .stream().map(mapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    public SessionDto getById(Long id) {
        log.info("getting session with id {} ", id);
        return mapper.sessionToSessionDto(repository.getById(id));
    }

    //todo: seats are null
    public SessionDto insert(SessionDto sessionDto) {

        log.info("inserting session: {}", sessionDto);
        Session session = repository.save(map(sessionDto));
        repository.insert_seats(session.getId());
        return map(repository.getById(session.getId()));
    }

    public SessionDto update(SessionDto sessionDto) {
        log.info("updating session: {}", sessionDto);
        Session session = mapper.sessionDtoToSession(sessionDto);
        repository.save(session);
        return sessionDto;
    }

    public void delete(Long id) {
        log.info("deleting session with id: {}", id);
        repository.deleteById(id);
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


    //todo
    public List<SessionDto> findInRange(String filter, List<SessionDto> sessions) {

        //cinema working time - 9.00 - 22.00(last movie starts)
        LocalDateTime todayStart = LocalDateTime.now();
        LocalDateTime todayEnd = LocalDateTime.now().withHour(22).withMinute(0).withSecond(0);

        LocalDateTime tomorrowStart = LocalDateTime.now().withHour(9).withMinute(0).withSecond(0).plusDays(1);
        LocalDateTime tomorrowEnd = LocalDateTime.now().withHour(22).withMinute(0).withSecond(0).plusDays(1);

        LocalDateTime thisWeekStart = LocalDateTime.now();
        LocalDateTime thisWeekEnd = LocalDateTime.now().withHour(22).withMinute(0).withSecond(0).plusDays(6);


        switch (filter) {
            case "today":
                return findsSessionInGivenTime(todayStart, todayEnd, sessions);
            case "tomorrow":
                return findsSessionInGivenTime(tomorrowStart, tomorrowEnd, sessions);
            case "week:":
                return findsSessionInGivenTime(thisWeekStart, thisWeekEnd, sessions);
            default:
                throw new IllegalArgumentException("Bad parameter");
        }
    }

    private List<SessionDto> findsSessionInGivenTime(LocalDateTime start, LocalDateTime end, List<SessionDto> list) {
        return list.stream().filter
                        (s -> s.getStartTime().isAfter(start)
                                && s.getStartTime().isBefore(end))
                .collect(Collectors.toList());
    }

    @Override
    public List<SessionDto> findSessionsWithTitle(String title) {
        return repository.findAll().stream()
                .filter(session -> session.getMovie().getEnTitle().equals(title)
                        || session.getMovie().getUaTitle().equals(title))
                .map(mapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto buyTicket(SessionDto sessionDto, UserDto userDto, Long seatId) {
        SeatDto seatDto = seatService.findById(seatId);
        if (seatDto.isTaken()) {
            throw new SeatIsAlreadyTakenException();
        }

        TicketDto ticketDto = TicketDto.builder()
                .seat(seatDto)
                .user(userDto)
                .price(calculatePrice(sessionDto, seatDto))
                .build();

        seatDto.setTicket(ticketDto);

        TicketDto ticket = ticketService.insert(ticketDto);
        seatService.update(seatDto);

        return ticket;
    }

    private final Comparator<SessionDto> byName = Comparator.comparing((SessionDto s) -> s.getMovie().getEnTitle());
    private final Comparator<SessionDto> byTime = Comparator.comparing(SessionDto::getStartTime);
    private final Comparator<SessionDto> bySeats = Comparator.comparing(SessionDto::getFreeSeats);

    private SessionDto map(Session session) {
        return mapper.sessionToSessionDto(session);
    }

    private Session map(SessionDto sessionDto) {
        return mapper.sessionDtoToSession(sessionDto);
    }

    private Long calculatePrice(SessionDto sessionDto, SeatDto seatDto) {
        return seatDto.isVip() ? sessionDto.getMovie().getPrice() + sessionDto.getPricing().getPrice() + Seat.VIP_PRICE :
                sessionDto.getMovie().getPrice() + sessionDto.getPricing().getPrice();
    }


}
