package Exception_Handling;

import java.util.Scanner;

class InvalidPasswordException extends Exception{

    String exception_message = "Invalid Password ";
    public InvalidPasswordException(String exception){
        this.exception_message += exception;
    }
}

public class Password_Validation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Instagram Login");
        System.out.print("Enter user id :- ");
        String userId = scanner.nextLine();
        System.out.print("Enter your password :- ");
        String password = scanner.nextLine();

        try {
            checkPassword(password);
            System.out.println("Valid Password");
        } catch (InvalidPasswordException e){
            System.out.println(e.exception_message);
        }
    }

    private static void checkPassword(String password) throws InvalidPasswordException {
        checkLength(password);
        checkSpecialCharacter(password);
        checkUpperCase(password);
        checkLowerCase(password);
        checkDigit(password);
        
    }

    private static void checkDigit(String password) throws InvalidPasswordException {
        boolean digitValid = false;
        for (int i = 0;i<password.length();i++){
            char ch = password.charAt(i);
            if (ch > 47 && ch < 58) {
                digitValid = true;
                break;
            }
        }
        if(!digitValid){
            throw new InvalidPasswordException("Password must contains at least one digit");
        }
    }

    private static void checkLowerCase(String password) throws InvalidPasswordException {
        boolean lowerCaseValid = false;
        for (int i = 0;i<password.length();i++){
            char ch = password.charAt(i);
            if (ch > 96 && ch < 123) {
                lowerCaseValid = true;
                break;
            }
        }
        if(!lowerCaseValid){
            throw new InvalidPasswordException("Password must contains at least one lower case alphabet");
        }
    }

    private static void checkLength(String password) throws InvalidPasswordException {
        if(password.length() < 5){
            throw  new InvalidPasswordException("Password length should be greater then 5");
        }
        else if (password.length() > 11) {
            throw new InvalidPasswordException("Password length should be lower then 11");
        }

    }


    private static void checkUpperCase(String password) throws InvalidPasswordException {
        boolean upperCaseValid = false;
        for (int i = 0;i<password.length();i++){
            char ch = password.charAt(i);
            if (ch > 64 && ch < 91) {
                upperCaseValid = true;
                break;
            }
        }
        if(!upperCaseValid){
            throw new InvalidPasswordException("Password must contains at least one upper case alphabet");
        }
    }

    private static void checkSpecialCharacter(String password) throws InvalidPasswordException {
        boolean specialCharValid = password.contains("@") || password.contains("!") || password.contains("#") || password.contains("&") || password.contains("*") || password.contains("%");

        if(!specialCharValid){
            throw new InvalidPasswordException("Password must contains at least one special characters “@ #  &  % * ! ”  ");

        }
    }
}
