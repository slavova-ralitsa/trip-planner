package com.example.tripplanner.exception;

import com.example.tripplanner.dto.ErrorCode;
import com.example.tripplanner.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(DestinationNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleDestinationNotFound(DestinationNotFoundException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.DESTINATION_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DestinationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleDestinationExists(DestinationAlreadyExistsException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.DESTINATION_ALREADY_EXISTS, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT); // Status 409
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(ErrorCode.GENERIC_ERROR, "Възникна неочаквана грешка в сървъра.");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
