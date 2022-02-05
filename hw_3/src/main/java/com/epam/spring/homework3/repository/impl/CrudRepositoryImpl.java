package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.DataAccessException;
import com.epam.spring.homework3.model.Entity;
import com.epam.spring.homework3.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class CrudRepositoryImpl<T extends Entity> implements CrudRepository<T> {

    protected List<T> entities = new ArrayList<>();

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public T getById(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataAccessException("Can't find entity"));
    }

    @Override
    public void insert(T entity) {
        entities.add(entity);
    }

    @Override
    public void delete(T entity) {
        entities.removeIf(listEntity -> listEntity.getId().equals(listEntity.getId()));
    }

    @Override
    public void update(T entity){
        int index = Math.toIntExact(entities.stream()
                .filter(listEntity -> entity.getId().equals(listEntity.getId()))
                .findFirst()
                .orElseThrow(() -> new DataAccessException("entity not found")).getId());
        entities.set(index,entity);
    }
}
