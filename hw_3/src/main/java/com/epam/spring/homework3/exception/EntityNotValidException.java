package com.epam.spring.homework3.exception;

public class EntityNotValidException extends RuntimeException {

    public EntityNotValidException() {
        super("Entity validation failed");
    }

    public EntityNotValidException(String message) {
        super(message);
    }
}