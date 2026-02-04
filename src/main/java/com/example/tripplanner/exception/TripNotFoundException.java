package com.example.tripplanner.exception;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException(String msg) {
        super(msg);
    }
}
