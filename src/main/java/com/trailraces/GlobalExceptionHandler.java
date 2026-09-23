package com.trailraces;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ConstraintViolationException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException exception) {

                ConstraintViolation<?> violation =
                        exception.getConstraintViolations()
                                .iterator()
                                .next();

                return new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        violation.getMessage()
                );
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ErrorResponse handleMethodArgumentNotValidException(
                MethodArgumentNotValidException exception) {

                String message;

                if (!exception.getBindingResult().getFieldErrors().isEmpty()) {
                        message = exception.getBindingResult()
                                .getFieldErrors()
                                .get(0)
                                .getDefaultMessage();
                } else {
                        message = exception.getBindingResult()
                                .getGlobalErrors()
                                .get(0)
                                .getDefaultMessage();
                }

                return new ErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        message
                );
        }
}