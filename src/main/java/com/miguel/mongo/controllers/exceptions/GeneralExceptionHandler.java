package com.miguel.mongo.controllers.exceptions;

import com.miguel.mongo.services.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.Instant;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> notFound(UserNotFoundException e) {

        int statusCode = HttpStatus.NOT_FOUND.value();

        StandardError error = new StandardError(Instant.now(), statusCode, e.getMessage());

        return ResponseEntity.status(statusCode).body(error);
    }
}