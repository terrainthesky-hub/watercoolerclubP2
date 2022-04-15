package com.watercooler.utilities.customExceptions;

public class EmptyField extends RuntimeException {
    public EmptyField(String message) {
        super(message);
    }
}
