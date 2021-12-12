package com.mikhalkou.pluralsight.spring.trackzila.exception;

public class ApplicationEmptyNameException extends Exception {

    public static final String DEFAULT_MESSAGE = "Application name cannot be empty.";

    public ApplicationEmptyNameException() {
        super(DEFAULT_MESSAGE);
    }

    public ApplicationEmptyNameException(String message) {
        super(message);
    }

    public ApplicationEmptyNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationEmptyNameException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public ApplicationEmptyNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
