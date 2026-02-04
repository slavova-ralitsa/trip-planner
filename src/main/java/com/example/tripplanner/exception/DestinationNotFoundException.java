package com.example.tripplanner.exception;

public class DestinationNotFoundException extends RuntimeException {

    public DestinationNotFoundException(String msg) {
        super(msg);
    }
}