package com.example.tripplanner.exception;

public class FavouriteDestinationAlreadyExistsException extends RuntimeException {
    public FavouriteDestinationAlreadyExistsException(Long id) {
        super("Favourite destination with id " + id + "already exists!");
    }
}
