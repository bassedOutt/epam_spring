package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.EntityDto;

import java.util.List;

public interface CrudService<T extends EntityDto> {
    List<T> getAll();
    T get(Long id);
    void insert(T entity);
    void update(T entity);
    void delete(T entity);
}
