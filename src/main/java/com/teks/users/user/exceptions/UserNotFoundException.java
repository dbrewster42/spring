package com.teks.users.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException{
//    private static final String = "User returned null";
    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(Throwable cause){
        super(cause);
    }
    public UserNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
