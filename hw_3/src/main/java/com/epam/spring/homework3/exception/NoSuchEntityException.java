package com.epam.spring.homework3.exception;

public class NoSuchEntityException extends RuntimeException{
    public NoSuchEntityException(String message){
        super(message);
    }
}
