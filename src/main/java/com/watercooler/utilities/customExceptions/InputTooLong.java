package com.watercooler.utilities.customExceptions;

public class InputTooLong extends RuntimeException{
    public InputTooLong(String message) {
        super(message);
    }
}
