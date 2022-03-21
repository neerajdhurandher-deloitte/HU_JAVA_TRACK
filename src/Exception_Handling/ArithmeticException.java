package Exception_Handling;

import java.util.Scanner;

public class ArithmeticException {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number :- ");
        int first_number = scanner.nextInt();
        System.out.print("Enter second number :- ");
        int second_number = scanner.nextInt();

        int result = 0;

        try{
            result = first_number/second_number;
            System.out.println("Result :- " + result);
        }
        catch (Exception e){
            System.out.println("Error :- "+e);
        }

        finally {
            System.out.println("Thank you");
        }
    }
}
