package com.epam.spring.homework3.service;

import com.epam.spring.homework3.service.impl.SessionServiceImpl;
import com.epam.spring.homework3.service.repository.SessionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class SessionServiceTest {

    @Spy
    private SessionRepository repository;

    @InjectMocks
    private SessionServiceImpl service;

    @Test
    public void shouldInsertSession(){

    }
}
