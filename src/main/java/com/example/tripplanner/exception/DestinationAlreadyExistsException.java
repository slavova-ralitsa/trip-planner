package com.example.tripplanner.exception;

public class DestinationAlreadyExistsException extends RuntimeException {

    public DestinationAlreadyExistsException(String msg) {
        super(msg);
    }
}