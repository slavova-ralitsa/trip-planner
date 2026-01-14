package com.example.tripplanner.dto;

public class ErrorResponseDTO {

    private ErrorCode errorCode;
    private String message;

    public ErrorResponseDTO(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}

