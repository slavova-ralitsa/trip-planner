package com.example.tripplanner.exception;

import com.example.tripplanner.dto.ErrorCode;
import com.example.tripplanner.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DestinationNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleDestinationNotFound(DestinationNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.DESTINATION_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DestinationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleDestinationExists(DestinationAlreadyExistsException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.DESTINATION_ALREADY_EXISTS, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserExists(UserAlreadyExistsException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.USER_ALREADY_EXISTS, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFound(UserNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.USER_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FavouriteDestinationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleFavouriteDestinationExists(FavouriteDestinationAlreadyExistsException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.FAVOURITE_DESTINATION_ALREADY_EXISTS, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FavouriteDestinationNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleFavouriteDestinationNotFound(FavouriteDestinationNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.USER_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TripNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleTripNotFound(TripNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.TRIP_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.GENERIC_ERROR, "Unexpected internal server error.");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
