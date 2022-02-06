package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.exception.DataAccessException;
import com.epam.spring.homework3.model.Entity;
import com.epam.spring.homework3.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class CrudRepositoryImpl<T extends Entity> implements CrudRepository<T> {

    protected List<T> entities = new ArrayList<>();

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public T getById(String id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DataAccessException("Can't find entity"));
    }

    @Override
    public void insert(T entity) {
        entity.setId(UUID.randomUUID().toString());
        entities.add(entity);
    }

    @Override
    public void delete(T entity) {
        entities.removeIf(listEntity -> listEntity.getId().equals(listEntity.getId()));
    }

    @Override
    public void update(T entity) {
        int index = getIndexById(entity.getId());
        if (index == -1) throw new DataAccessException("No entity with id " + entity.getId() + " in the database");
        entities.set(index, entity);
    }

    private int getIndexById(String id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null && entities.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
