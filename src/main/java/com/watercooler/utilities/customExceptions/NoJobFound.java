package com.watercooler.utilities.customExceptions;

public class NoJobFound extends RuntimeException{

    NoJobFound(String message){
        super(message);
    }
}
