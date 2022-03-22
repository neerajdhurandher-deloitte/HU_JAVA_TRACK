package Main_Assignment.Functionalities;

import Main_Assignment.Exceptions.*;

public class UserDetailValidator {
    // empty constructor
    public UserDetailValidator(){

    }

    public boolean emptyChecker(String data ,String entity_type) throws EmptyFieldException {
        if(data.isBlank()){
            throw new EmptyFieldException(entity_type);
        }
        return true;
    }

    public boolean emptyFieldChecker(String data){
        return (data.isBlank());
    }

    // function for checking given password is valid type or not

    public boolean passwordValidator(String password) throws InvalidPasswordException {

        Password_Validation password_validation = new Password_Validation();

        return password_validation.checkPassword(password);
    }


    // function for checking given phone number is valid type or not

    public boolean phoneNumberValidator(String phoneNum) throws PhoneNumberException {

        if(phoneNum.length() != 10){
            throw new PhoneNumberException("Phone number length should be equal to 10");
        }

        for(int i = 0;i<phoneNum.length();i++){
            char phoneNumChar = phoneNum.charAt(i);
            if(phoneNumChar< 47|| phoneNumChar > 58) {
                throw new PhoneNumberException("Phone number should only contains number 0 to 10 ");
            }
        }

        return true;
    }

    // function for checking given salary is valid type or not

    public boolean salaryValidation(int salary) throws SalaryException {
        if(salary==0){
            throw new SalaryException("Salary can't be equal to zero");
        }
        else if(salary<0){
            throw new SalaryException("Salary should be positive value");
        }
        return true;
    }

    // function for checking given Age is valid type or not

    public boolean AgeValidation(int age) throws AgeException {
        if(age < 18 || age > 90){
            throw new AgeException("Age should be in between 18 to 90");
        }
        return true;
    }


}
