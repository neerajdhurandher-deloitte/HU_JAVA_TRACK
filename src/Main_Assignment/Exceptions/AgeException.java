package Main_Assignment.Exceptions;

public class AgeException extends Exception implements CustomException{
    private String ageExceptionMessage = "";

    public AgeException(String exception){
        this.ageExceptionMessage = exception;
    }

    public String getExceptionMessage(){
        return this.ageExceptionMessage;
    }
}
