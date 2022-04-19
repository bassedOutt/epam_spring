package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.SeatDto;
import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.dto.TicketDto;
import com.epam.spring.homework3.dto.UserDto;
import com.epam.spring.homework3.dto.mapper.EntityMapper;
import com.epam.spring.homework3.exception.SeatIsAlreadyTakenException;
import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.model.Session;
import com.epam.spring.homework3.service.SeatService;
import com.epam.spring.homework3.service.TicketService;
import com.epam.spring.homework3.service.UserService;
import com.epam.spring.homework3.service.repository.SessionRepository;
import com.epam.spring.homework3.service.SessionService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class SessionServiceImpl implements SessionService {

    @NonNull
    private SessionRepository repository;

    @NonNull
    private TicketService ticketService;

    @NonNull
    private SeatService seatService;

    @NonNull
    private UserService userService;

    private final EntityMapper mapper = EntityMapper.INSTANCE;


    @Override
    public List<SessionDto> findAll() {
        List<Session> sessions = repository.findAll();
        return sessions
                .stream().map(mapper::toSessionDto)
                .collect(Collectors.toList());
    }

    public SessionDto findById(Long id) {
        log.info("getting session with id {} ", id);
        return mapper.toSessionDto(repository.getById(id));
    }

    //todo: seats are null
    public SessionDto insert(SessionDto sessionDto) {

        log.info("inserting session: {}", sessionDto);
        Session session = repository.save(map(sessionDto));
        repository.insert_seats(session.getId());

        return map(session);
    }

    public SessionDto update(SessionDto sessionDto) {
        log.info("updating session: {}", sessionDto);
        Session session = mapper.fromSessionDto(sessionDto);
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
                .map(mapper::toSessionDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto buyTicket(Long sessionId, Long userId, Long seatId) {

        SeatDto seatDto = seatService.findById(seatId);

        SessionDto sessionDto = findById(sessionId);

        UserDto userDto = userService.findById(userId);

        if (seatDto.isTaken()) {
            throw new SeatIsAlreadyTakenException();
        }

        TicketDto ticketDto = TicketDto.builder()
                .seat(seatDto)
                .price(calculatePrice(sessionDto, seatDto))
                .build();

        userDto.addTicket(ticketDto);

        TicketDto ticket = ticketService.insert(ticketDto);
        userService.update(userDto);

        return ticket;
    }

    private final Comparator<SessionDto> byName = Comparator.comparing((SessionDto s) -> s.getMovie().getEnTitle());
    private final Comparator<SessionDto> byTime = Comparator.comparing(SessionDto::getStartTime);
    private final Comparator<SessionDto> bySeats = Comparator.comparing(SessionDto::getFreeSeats);

    private SessionDto map(Session session) {
        return mapper.toSessionDto(session);
    }

    private Session map(SessionDto sessionDto) {
        return mapper.fromSessionDto(sessionDto);
    }

    private Long calculatePrice(SessionDto sessionDto, SeatDto seatDto) {
        return seatDto.getIsVip() ? sessionDto.getMovie().getPrice() + sessionDto.getPricing().getPrice() + Seat.VIP_PRICE :
                sessionDto.getMovie().getPrice() + sessionDto.getPricing().getPrice();
    }

}
