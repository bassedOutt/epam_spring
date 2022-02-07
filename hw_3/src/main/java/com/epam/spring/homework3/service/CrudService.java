package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.EntityDto;
import com.epam.spring.homework3.dto.UserDto;

import java.util.List;

public interface CrudService<T extends EntityDto> {
    List<T> getAll();
    T getById(String id);
    T insert(T entity);
    T update(T entity);
    void delete(String id);
}
