package Main_Assignment;

import Main_Assignment.Database.DBFunctionalities;
import Main_Assignment.Database.User_Object;
import Main_Assignment.Exceptions.EmptyFieldException;
import Main_Assignment.Functionalities.UserDetailValidator;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static UserDetailValidator userDetailValidator = new UserDetailValidator();
    static DBFunctionalities db_Functionalities;



    public static void main(String[] args) throws Exception {

        db_Functionalities = new DBFunctionalities();

        printWelcomeHeading(" to User Database *****");

        logInRegistrationPage();
    }

    private static void logInRegistrationPage() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Login");
        System.out.println("2.Registration");
        System.out.print("Enter your choice :- ");

        int loginRegiChoice = scanner.nextInt();
        switch (loginRegiChoice) {
            case 1 -> goTOLogin();
            case 2 -> goToRegistration();
            default -> System.out.println("Please re run the program and select a valid option");
        }
    }

    private static void goToRegistration() throws EmptyFieldException {
        System.out.println("r");

        Scanner scanner = new Scanner(System.in);

        boolean validUserName = false;
        boolean validPassword = false;
        String readUserName = "";
        String readUserPassword = "";

        while (!validUserName) {

            System.out.print("Enter username : ");
            readUserName = scanner.nextLine();

            db_Functionalities.db_operations.setCurrentUserName(readUserName);

            try {
                db_Functionalities.db_operations.readDB();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                validUserName = db_Functionalities.userNameAvailability();
            }
        }


        while (!validPassword) {

            System.out.print("Enter your password : ");
            readUserPassword = scanner.nextLine();
            System.out.print("Re enter your password : ");
            String reReadUserPassword = scanner.nextLine();

            if(reReadUserPassword.equals(reReadUserPassword)) {

                try {
                    validPassword = userDetailValidator.passwordValidator(readUserPassword);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else {
                System.out.println("Entered both password doesn't match. please try again....");
            }
        }

        User_Object user_object = new User_Object();
        user_object.setUserId(db_Functionalities.db_operations.getUserListSize()+1);
        user_object.setUserName(readUserName);
        user_object.setPassword(readUserPassword);

        try{
            db_Functionalities.addUserOperation(user_object);
            gotoUserDashBoard();
        }catch (EmptyFieldException exception){
            System.out.println(exception.getExceptionMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void goTOLogin() throws Exception {
        Scanner scanner = new Scanner(System.in);

        boolean validPassword = false;

        System.out.print("Enter your user name : ");
        String readUserName = scanner.nextLine();
        db_Functionalities.db_operations.setCurrentUserName(readUserName);
        try {
            db_Functionalities.db_operations.readDB();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(db_Functionalities.userNameAvailability()){
            System.out.println("Oops user doesn't exits");
            goTOLogin();
        }

        String readUserPassword = "";

        while (!validPassword) {
            System.out.print("Enter your password : ");
            readUserPassword = scanner.nextLine();
            try{
                validPassword = db_Functionalities.passwordChecker(readUserPassword);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            if(!validPassword){
                System.out.println("Incorrect password. Please try again...");
            }
        }
        printWelcomeHeading(db_Functionalities.db_operations.getCurrent_user_object().getName());
        gotoUserDashBoard();
    }

    private static void printWelcomeHeading(String printData) {
        System.out.println("***** Welcome " + printData+" ******");

    }

    private static void gotoUserDashBoard() throws Exception {

        Scanner scanner = new Scanner(System.in);

        int choice = 0;


        while (choice != 5) {
            System.out.println();
            System.out.println("1. Add User Data ");
            System.out.println("2. List User Data ");
            System.out.println("3.Update User Data ");
            System.out.println("4. Delete User Data ");
            System.out.println("5. Exit ");

            System.out.print("Enter your choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    try {
                        db_Functionalities.addUserOperation(db_Functionalities.db_operations.getCurrent_user_object());
                    } catch (EmptyFieldException exception) {
                        System.out.println(exception.getExceptionMessage());
                    }
                }
                case 2 -> db_Functionalities.getUserDetailsList();

                case 3 -> db_Functionalities.updateUserOperation();

                case 4 -> {
                    db_Functionalities.deleteUser();
                    logInRegistrationPage();
                }

                case 5 -> {
                    db_Functionalities.db_operations.updateDB();
                    continue;
                }

                default -> {
                    System.out.println("Please enter valid choice ");
                }
            }
        }
    }



}
