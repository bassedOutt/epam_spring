package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.SessionDto;
import com.epam.spring.homework3.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SessionController {
    private SessionService sessionService;

    @Autowired
    public void setUserService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<SessionDto> getAllSessions(@PathVariable String language) {
        log.info("getting list of sessions");
        return sessionService.findAllLocalized(language);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{title}")
    public List<SessionDto> getSessionWithMovie(@PathVariable String title) {
        log.info("getting all sessions with title: {}", title);
        return sessionService.findSessionsWithTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public SessionDto insertMovie(@RequestBody SessionDto sessionDto) {
        log.info("creating session : {}", sessionDto);
        return sessionService.insert(sessionDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public SessionDto updateMovie(@RequestBody SessionDto sessionDto) {
        log.info("updating session : {}", sessionDto);
        return sessionService.update(sessionDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public ResponseEntity<Void> deleteMovie(@PathVariable String id) {
        log.info("deleting session with an id: {}", id);
        sessionService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
