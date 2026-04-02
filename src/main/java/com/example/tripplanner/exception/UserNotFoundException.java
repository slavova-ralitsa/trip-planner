package com.example.tripplanner.exception;

import com.example.tripplanner.dto.ErrorCode;

public class UserNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found!");
        this.errorCode = ErrorCode.USER_NOT_FOUND;
    }

    public UserNotFoundException(String username) {
        super("User with username " + username + " not found!");
        this.errorCode = ErrorCode.USER_NOT_FOUND;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}