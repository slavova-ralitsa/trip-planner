package com.example.tripplanner.exception;

public class FavouriteDestinationNotFoundException extends RuntimeException {
    public FavouriteDestinationNotFoundException(Long destinationId, Long userId) {
        super("Destination with id " + destinationId + "not found for user " + userId + "!");
    }
}
