package com.watercooler.utilities;

public class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }

    public static void main(String[] args) {
//        the code below is for the exception if it extends the base Exception class
//        try{
//            throw new TheOneException("this is my message");
//        } catch(TheOneException e){
//            System.out.println(e.getMessage());
//        }
//        the code below does not require a try/catch block if the exception is an unchecked one
        throw new CustomUncheckedException("If this was a function being called elsewhere I could handle this exception there");

        // because we ducked the checked exception in the duckingExceptions method, we have to handle it here in main
//        try{
//            duckingExceptions();
//        } catch(TheOneException e){
//            System.out.println(e.getMessage());
//        }
    }
}//
//    public static void duckingExceptions() throws TheOneException{
//        throw new TheOneException("this is going to be ducked");
//    }
//}
