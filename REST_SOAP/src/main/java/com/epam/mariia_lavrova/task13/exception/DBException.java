package com.epam.mariia_lavrova.task13.exception;

public class DBException extends IllegalArgumentException {
    
    public DBException() {
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
