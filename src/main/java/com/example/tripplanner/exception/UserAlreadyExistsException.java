package com.example.tripplanner.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(Long id) {
        super("User with id " + id + " already exists!");

    }
}