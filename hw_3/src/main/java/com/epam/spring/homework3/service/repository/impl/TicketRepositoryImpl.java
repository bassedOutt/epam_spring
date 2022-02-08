package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.model.Ticket;
import com.epam.spring.homework3.service.repository.TicketRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryImpl extends CrudRepositoryImpl<Ticket> implements TicketRepository {
}
