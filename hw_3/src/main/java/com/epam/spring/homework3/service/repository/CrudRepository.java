package com.epam.spring.homework3.service.repository;

import com.epam.spring.homework3.model.Entity;

import java.util.List;

public interface CrudRepository<T extends Entity> {
    List<T> getAll();

    T getById(String id);

    T insert(T entity);

    void update(T entity);

    void delete(String id);
}
