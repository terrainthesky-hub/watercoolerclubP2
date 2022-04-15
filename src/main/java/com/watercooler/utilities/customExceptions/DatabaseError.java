package com.watercooler.utilities.customExceptions;

public class DatabaseError extends RuntimeException {
    public DatabaseError(String message) {
        super(message);
    }
}