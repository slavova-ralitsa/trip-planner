package com.example.tripplanner.exception;

public class NoSuchDestinationExistsException extends RuntimeException {
    public NoSuchDestinationExistsException(String msg) {
        super(msg);
    }
}