package com.example.tripplanner.exception;

public class DestinationAlreadyExistsException extends RuntimeException {

    public DestinationAlreadyExistsException(Long id) {
        super("Destination with id " + id + "already exists!");
    }
}