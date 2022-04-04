package com.epam.spring.homework3.exception;


public class EntityInsertionException extends RuntimeException {

    public EntityInsertionException(){
        super("Failed to insert entity");
    }

    public EntityInsertionException(String message) {
        super(message);
    }
}
