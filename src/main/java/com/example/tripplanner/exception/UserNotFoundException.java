package com.example.tripplanner.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User with id " + id + " already exists!");
    }

    public UserNotFoundException(String username) {
        super("User with username " + username + " already exists!");
    }
}