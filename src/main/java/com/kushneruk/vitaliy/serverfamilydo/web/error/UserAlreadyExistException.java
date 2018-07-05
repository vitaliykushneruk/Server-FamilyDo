package com.kushneruk.vitaliy.serverfamilydo.web.error;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(final String message) {
        super(message);
    }
}
