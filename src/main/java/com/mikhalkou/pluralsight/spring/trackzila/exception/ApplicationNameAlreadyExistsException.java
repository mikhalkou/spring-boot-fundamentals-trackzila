package com.mikhalkou.pluralsight.spring.trackzila.exception;

public class ApplicationNameAlreadyExistsException extends Throwable {
    public ApplicationNameAlreadyExistsException(String message) {
        super(message);
    }

    public ApplicationNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationNameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
