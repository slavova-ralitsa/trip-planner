package com.example.tripplanner.exception;

public class FavouriteDestinationAlreadyExistsException extends RuntimeException {
    public FavouriteDestinationAlreadyExistsException(String msg) {
        super(msg);
    }
}
