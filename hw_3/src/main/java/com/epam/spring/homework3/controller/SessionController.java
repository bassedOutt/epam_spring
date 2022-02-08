package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/session")
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public void setUserService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SessionDto> getAllSessions(@RequestParam String language,
                                           @RequestParam(required = false) String sorter,
                                           @RequestParam(required = false) String range) {
        log.info("getting list of sessions");
        List<SessionDto> list = sessionService.findAllLocalized(language);
        if (sorter != null) {
            list = sessionService.sortSessions(sorter, list);
        }
        if (range != null) {
            list = sessionService.findInRange(range, list);
        }
        return list;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{title}")
    public List<SessionDto> getSessionWithMovie(@PathVariable String title) {
        log.info("getting all sessions with title: {}", title);
        return sessionService.findSessionsWithTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SessionDto insertSession(@RequestBody SessionDto sessionDto) {
        log.info("creating session : {}", sessionDto);
        return sessionService.insert(sessionDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public SessionDto updateSession(@RequestBody SessionDto sessionDto) {
        log.info("updating session : {}", sessionDto);
        return sessionService.update(sessionDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable String id) {
        log.info("deleting session with an id: {}", id);
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
