package Main_Assignment.Exceptions;

public class SalaryException extends Exception implements CustomException{

    private String salaryExceptionMessage = "";

    public SalaryException(String exception){
        this.salaryExceptionMessage = exception;
    }

    public String getExceptionMessage(){
        return this.salaryExceptionMessage;
    }
}
