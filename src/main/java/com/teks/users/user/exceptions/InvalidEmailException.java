package com.teks.users.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("error")
@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason="Email is not Valid")
public class InvalidEmailException extends RuntimeException {
    public  InvalidEmailException(String msg){
        super(msg);
    }
}
