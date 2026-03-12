package com.example.tripplanner.exception;

public class DestinationNotFoundException extends RuntimeException {

    public DestinationNotFoundException(Long id) {
        super("Destination with id " + id + " not found!");
    }
    public DestinationNotFoundException(double latitude, double longitude) {
        super("Destination with latitude " + latitude + " and longitude " + longitude + " not found");
    }
}