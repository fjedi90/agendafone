package com.felipeleitao.agenda_telefonica.services.exceptions;

public class AuthorizationException extends RuntimeException{

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
