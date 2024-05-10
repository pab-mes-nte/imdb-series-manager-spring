package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerExceptionHandler {
    // TODO: Give controller advices a look

    // Parameter Missing Exception
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<Object> handleMissingParameter(Exception ex) {
        return ResponseEntity.badRequest().body("Parameter Missing");
    }

    // Incorrect Parameter Data Type Exception
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    protected ResponseEntity<Object> handleIncorrectParameter(Exception ex) {
        return ResponseEntity.badRequest().body("Incorrect Parameter");
    }
}