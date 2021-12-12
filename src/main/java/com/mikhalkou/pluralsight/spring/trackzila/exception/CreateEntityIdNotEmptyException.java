package com.mikhalkou.pluralsight.spring.trackzila.exception;

public class CreateEntityIdNotEmptyException extends Exception {
    public CreateEntityIdNotEmptyException(String message) {
        super(message);
    }

    public CreateEntityIdNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateEntityIdNotEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
