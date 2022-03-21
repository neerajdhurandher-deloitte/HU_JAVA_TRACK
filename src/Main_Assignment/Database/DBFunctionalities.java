package Main_Assignment.Database;

import Main_Assignment.Exceptions.AgeException;
import Main_Assignment.Exceptions.EmptyFieldException;
import Main_Assignment.Exceptions.PhoneNumberException;
import Main_Assignment.Exceptions.SalaryException;
import Main_Assignment.Functionalities.UserDetailValidator;

import java.io.IOException;
import java.util.Scanner;

public class DBFunctionalities {

    public DB_Operations db_operations;
    public UserDetailValidator userDetailValidator;

    public DBFunctionalities() throws IOException {
        this.db_operations = new DB_Operations();
        this.userDetailValidator = new UserDetailValidator();
    }

    public void addUserOperation(User_Object user_object) throws EmptyFieldException {

        Scanner scanner = new Scanner(System.in);
        boolean validName = false;
        boolean validAge = false;
        boolean validCompanyName = false;
        boolean validDesignation = false;
        boolean validSalary = false;
        boolean validAddress = false;
        boolean validPhoneNumber = false;

        while (!validName) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
            try {
                validName = userDetailValidator.emptyChecker(name, "Name");
            } catch (EmptyFieldException exception) {
                System.out.println(exception.getExceptionMessage());
            }
            finally {
                user_object.setName(name);
            }
        }
        while (!validAge) {
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            try {
                validAge = userDetailValidator.AgeValidation(age);
            }catch (AgeException exception){
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setAge(age);
            }
        }

        while (!validCompanyName) {
            System.out.println("Enter company name: ");
            String company_name = scanner.nextLine();
            try {
                validCompanyName = userDetailValidator.emptyChecker(company_name, "Company Name");
            } catch (EmptyFieldException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setCompanyName(company_name);
            }
        }
        while (!validDesignation) {
            System.out.println("Enter designation: ");
            String designation = scanner.nextLine();
            try {
                validDesignation = userDetailValidator.emptyChecker(designation, "Designation");
            } catch (EmptyFieldException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setDesignation(designation);
            }
        }

        while (!validSalary) {
            System.out.println("Enter salary: ");
            int salary = scanner.nextInt();
            try {
                validSalary = userDetailValidator.salaryValidation(salary);
            } catch (SalaryException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setSalary(salary);
            }
        }

        while (!validAddress) {
            System.out.println("Enter address: ");
            String address = scanner.nextLine();
            try {
                validAddress = userDetailValidator.emptyChecker(address, "Address");
            } catch (EmptyFieldException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setAddress(address);
            }
        }
        while (!validPhoneNumber) {
            System.out.println("Enter phone_number: ");
            String phone_number = scanner.nextLine();
            try {
                validPhoneNumber = userDetailValidator.phoneNumberValidator(phone_number);
            } catch (PhoneNumberException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setPhoneNumber(phone_number);
            }
        }

        db_operations.addUser(user_object);

    }

    public void updateUserOperation(){

    }

    public void getUserDetailsList(){
        db_operations.getUserDetails();
    }

    public void deleteUser(){

    }

    public boolean userNameAvailability(){

        return (db_operations.getCurrent_user_object() == null);
    }

    public boolean passwordChecker(String password){
        if(db_operations.getCurrent_user_object() != null)
            return (db_operations.getCurrent_user_object().getPassword().equals(password));
        else return true;
    }

}
