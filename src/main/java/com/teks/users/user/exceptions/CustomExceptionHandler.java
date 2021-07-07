package com.teks.users.user.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<Object> resolveUserNotFoundException(UserNotFoundException e, WebRequest req){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ErrorResponse errorResponse = new ErrorResponse(time,
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage(),
                req.getDescription(false));
        return handleExceptionInternal(e, errorResponse.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, req);
    }

    @ExceptionHandler(value = InvalidEmailException.class)
    protected ResponseEntity<Object> resolveInvalidEmailException(InvalidEmailException e, WebRequest req){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ErrorResponse errorResponse = new ErrorResponse(time,
                HttpStatus.EXPECTATION_FAILED.value(),
                HttpStatus.EXPECTATION_FAILED.getReasonPhrase(),
                e.getMessage(),
                req.getDescription(true));
        return handleExceptionInternal(e, errorResponse.toString(), new HttpHeaders(), HttpStatus.EXPECTATION_FAILED, req);
    }
}
