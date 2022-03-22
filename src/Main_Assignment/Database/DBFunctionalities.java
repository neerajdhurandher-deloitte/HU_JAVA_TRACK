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
                System.out.print("Enter name: ");
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
            System.out.print("Enter age: ");
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
            System.out.print("Enter company name: ");
            String company_name = "";
            try {
                company_name = scanner.nextLine();
                validCompanyName = userDetailValidator.emptyChecker(company_name, "Company Name");
            } catch (EmptyFieldException exception) {
                System.out.println(exception.getExceptionMessage());
            }finally {
                user_object.setCompanyName(company_name);
            }
        }
        while (!validDesignation) {
            System.out.print("Enter designation: ");
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
            System.out.print("Enter salary: ");
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
            System.out.print("Enter address: ");
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
            System.out.print("Enter phone_number: ");
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
        db_operations.setCurrent_user_object(user_object);
        db_operations.setCurrentUserName(user_object.getUserName());
        db_operations.printUser(db_operations.getCurrent_user_object());

    }

    public void updateUserOperation(){
        Scanner scanner = new Scanner(System.in);
        User_Object temp_user = db_operations.getCurrent_user_object();
        int updateFieldChoice = 0;

        while (updateFieldChoice != 8){
            System.out.println("Select which field you want to update");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Company Name");
            System.out.println("4. Designation");
            System.out.println("5. Salary");
            System.out.println("6. Address");
            System.out.println("7. Phone Number ");
            System.out.println("8. Exit ");

            System.out.print("Enter your choice :- ");
            updateFieldChoice = scanner.nextInt();
            temp_user = updateAField(updateFieldChoice,temp_user);
        }
        db_operations.updateUserDetails(temp_user);
        System.out.println("Update successfully and updated user details are :- ");
        db_operations.printUser(db_operations.getCurrent_user_object());

    }

    protected User_Object updateAField(int field, User_Object temp_user) {
        Scanner scanner = new Scanner(System.in);

        switch (field){
            case 1 -> {
                System.out.print("Enter new Name :- ");
                String newName = scanner.nextLine();
                if(!userDetailValidator.emptyFieldChecker(newName))
                    temp_user.setName(newName);
            }case 2 -> {
                System.out.print("Enter new Age :- ");
                int newAge = scanner.nextInt();
                // :TODO add int checker
                temp_user.setAge(newAge);
            }
            case 3 -> {
                System.out.print("Enter new Company Name :- ");
                String newCompanyName = scanner.nextLine();
                if(!userDetailValidator.emptyFieldChecker(newCompanyName))
                    temp_user.setCompanyName(newCompanyName);
            }
            case 4 -> {
                System.out.print("Enter new Designation :- ");
                String newDesignation = scanner.nextLine();
                if(!userDetailValidator.emptyFieldChecker(newDesignation))
                    temp_user.setDesignation(newDesignation);
            }
            case 5 -> {
                System.out.print("Enter new Salary :- ");
                int newSalary = scanner.nextInt();
                // :TODO add int checker
                temp_user.setSalary(newSalary);
            }
            case 6 -> {
                System.out.print("Enter new Address :- ");
                String newAddress = scanner.nextLine();
                if(!userDetailValidator.emptyFieldChecker(newAddress))
                    temp_user.setAddress(newAddress);
            }

            case 7 -> {
                System.out.print("Enter new Phone Number :- ");
                String newPhoneNumber = scanner.nextLine();
                if(!userDetailValidator.emptyFieldChecker(newPhoneNumber))
                    temp_user.setPhoneNumber(newPhoneNumber);
            }
            case 8 -> {
                break;
            }
            default -> System.out.println("Please Enter valid option");

        }
        return temp_user;
    }

    public void getUserDetailsList(){
        db_operations.getUserDetails();
    }

    public void deleteUser(){
        db_operations.deleteUser();
        System.out.println("THE USER RECORD IS DELETED SUCCESSFULLY ");
        db_operations.getAllUserDetails();

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
