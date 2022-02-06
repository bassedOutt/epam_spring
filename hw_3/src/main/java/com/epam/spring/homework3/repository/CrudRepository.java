package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Entity;

import java.util.List;

public interface CrudRepository<T extends Entity> {
    List<T> getAll();

    T getById(String id);

    void insert(T entity);

    void update(T entity);

    void delete(T entity);
}
