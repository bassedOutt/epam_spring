package com.epam.spring.homework3.exception;

public class DataAccessException extends RuntimeException{
    public DataAccessException(String message){
        super(message);
    }

}
