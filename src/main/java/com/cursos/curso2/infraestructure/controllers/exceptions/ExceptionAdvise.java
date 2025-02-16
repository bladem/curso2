package com.cursos.curso2.infraestructure.controllers.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvise {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public String handleException(Exception e){
        return e.getMessage();
    }
}
