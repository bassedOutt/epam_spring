package com.epam.spring.homework3.service.repository.impl;

import com.epam.spring.homework3.model.Seat;
import com.epam.spring.homework3.service.repository.SeatRepository;
import org.springframework.stereotype.Repository;

@Repository
class SeatRepositoryImpl extends CrudRepositoryImpl<Seat> implements SeatRepository {
}
