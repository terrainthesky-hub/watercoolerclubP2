package com.watercooler.utilities.customExceptions.Lesley;

public class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        throw new CustomUncheckedException("If this was a function being called elsewhere I could handle this exception there");
    }
}
