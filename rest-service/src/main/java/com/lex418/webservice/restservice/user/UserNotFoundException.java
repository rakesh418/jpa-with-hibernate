package com.lex418.webservice.restservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "fucked up user")
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super();
    }
}
