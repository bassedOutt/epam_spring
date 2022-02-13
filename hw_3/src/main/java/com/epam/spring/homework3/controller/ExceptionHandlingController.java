package com.epam.spring.homework3.controller;


import com.epam.spring.homework3.exception.EntityCreationException;
import com.epam.spring.homework3.exception.EntityNotFoundException;
import com.epam.spring.homework3.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;

import static com.epam.spring.homework3.model.enums.ErrorType.*;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiError handleEntityNotFoundException(EntityNotFoundException ex, HandlerMethod hm) {
        log.error("Handling exception : {}. method: {}", ex.getMessage(), hm.getMethod().getName());
        return new ApiError(ex.getMessage(), ENTITY_NOT_FOUND_ERROR_TYPE, LocalDateTime.now());
    }

    @ExceptionHandler(EntityCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleEntityCreationException(EntityCreationException ex, HandlerMethod hm) {
        log.error("Handling exception : {}. method: {}", ex.getMessage(), hm.getMethod().getName());
        return new ApiError(ex.getMessage(), ENTITY_CREATION_FAILED_ERROR_TYPE, LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleNotValidArgumentException(MethodArgumentNotValidException ex, HandlerMethod hm) {
        log.error("Handling exception : {}. method: {}", ex.getMessage(), hm.getMethod().getName());
        return new ApiError(ex.getMessage(),ARGUMENT_NOT_VALID_ERROR_TYPE , LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleInternalServerError(Exception ex, HandlerMethod hm) {
        log.error("Handling exception : {}. method: {}", ex.getMessage(), hm.getMethod().getName());
        return new ApiError(ex.getMessage(), FATAL_ERROR_TYPE, LocalDateTime.now());
    }


}
