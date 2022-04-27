package com.watercooler.utilities.customExceptions;

public class NoJobFound extends RuntimeException{

    public NoJobFound(String message){
        super(message);
    }
}
