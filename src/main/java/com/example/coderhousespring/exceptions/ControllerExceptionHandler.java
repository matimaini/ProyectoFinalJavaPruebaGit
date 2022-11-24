package com.example.coderhousespring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class ControllerExceptionHandler  {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorMessage> productNotFoundException(NotFoundException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                LocalDate.now(),
                e.getMessage(),
                request.getDescription(false)

        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AuthErrorException.class)
    public ResponseEntity<ErrorMessage> authErrorException(AuthErrorException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.UNAUTHORIZED.value(),
                LocalDate.now(),
                e.getMessage(),
                request.getDescription(false)

        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity<ErrorMessage> userExistsException(UserExistsException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                LocalDate.now(),
                e.getMessage(),
                request.getDescription(false)

        );
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }



}
