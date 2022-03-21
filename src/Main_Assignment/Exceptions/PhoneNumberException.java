package Main_Assignment.Exceptions;

public class PhoneNumberException extends Exception implements CustomException{

    private String exceptionString = "";

    public PhoneNumberException(String exception){
        this.exceptionString = exception;
    }
    public String getExceptionMessage(){
        return this.exceptionString;
    }
}
