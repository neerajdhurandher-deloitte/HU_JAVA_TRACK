package Main_Assignment.Exceptions;

public class InvalidPasswordException extends Exception implements CustomException{

    private String passwordExceptionMessage  = "Invalid Password ";

    public InvalidPasswordException(String exception) {
        this.passwordExceptionMessage += exception;
    }

    @Override
    public String getExceptionMessage() {
        return this.passwordExceptionMessage;
    }
}
