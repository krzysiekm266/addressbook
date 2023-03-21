package com.krzysiekm266.addressbook.person.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersonExceptionsHandler {

    @ExceptionHandler(value = {PersonIllegalStateException.class})
    public ResponseEntity<Object> handlePersonIllegalStateException(PersonIllegalStateException ex) {
        return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);

    }
}
