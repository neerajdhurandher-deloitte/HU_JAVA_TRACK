package Main_Assignment.Exceptions;

public class EmptyFieldException extends Exception implements CustomException{

    private String entity_type = "";

    public EmptyFieldException(String entity_type){
        this.entity_type = entity_type;
    }

    @Override
    public String getExceptionMessage() {
        return (this.entity_type+" can't be empty");
    }
}
