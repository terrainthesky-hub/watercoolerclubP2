package com.watercooler.utilities.customExceptions;

public class NoApplicants extends RuntimeException{

    NoApplicants(String message){
        super(message);
    }
}
