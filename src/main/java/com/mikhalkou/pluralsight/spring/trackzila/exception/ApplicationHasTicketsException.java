package com.mikhalkou.pluralsight.spring.trackzila.exception;

public class ApplicationHasTicketsException extends Exception {
    public ApplicationHasTicketsException(String message) {
        super(message);
    }

    public ApplicationHasTicketsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationHasTicketsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
