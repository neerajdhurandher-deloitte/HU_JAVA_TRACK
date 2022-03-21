package Main_Assignment.Functionalities;


import Main_Assignment.Exceptions.InvalidPasswordException;

public class Password_Validation {
    
    public Password_Validation() {
    }

    public boolean checkPassword(String password) throws InvalidPasswordException {
        
       boolean checkLengthBool = false;
       boolean checkSpecialCharacterBool = false;
       boolean checkUpperCaseBool = false;
       boolean checkLowerCaseBool = false;
       boolean checkDigitBool = false;

            try {
                checkLengthBool = checkLength(password);
                checkSpecialCharacterBool = checkSpecialCharacter(password);
                checkUpperCaseBool = checkUpperCase(password);
                checkLowerCaseBool = checkLowerCase(password);
                checkDigitBool = checkDigit(password);
            }catch (InvalidPasswordException exception){
                System.out.println("catch "+exception.getExceptionMessage());
            }

        return checkLengthBool && checkSpecialCharacterBool && checkUpperCaseBool && checkLowerCaseBool && checkDigitBool;
    }

    private  boolean checkDigit(String password) throws InvalidPasswordException {
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
        return digitValid;
    }

    private  boolean checkLowerCase(String password) throws InvalidPasswordException {
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
        return lowerCaseValid;
    }

    private  boolean checkLength(String password) throws InvalidPasswordException {
            boolean lengthbool = true;
            if(password.length() < 5){
                lengthbool = false;
                throw  new InvalidPasswordException("Password length should be greater then 5");
            } 
            else if (password.length() > 11) {
                lengthbool = false;
                throw new InvalidPasswordException("Password length should be lower then 11");
            }
        return lengthbool;
    }


    private  boolean checkUpperCase(String password) throws InvalidPasswordException {
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
        return upperCaseValid;
    }

    private  boolean checkSpecialCharacter(String password) throws InvalidPasswordException {
        boolean specialCharValid = password.contains("@") || password.contains("!") || password.contains("#") || password.contains("&") || password.contains("*") || password.contains("%");

        if(!specialCharValid){
            throw new InvalidPasswordException("Password must contains at least one special characters “@ #  &  % * ! ”  ");
        }
        
        return specialCharValid;
    }
}

