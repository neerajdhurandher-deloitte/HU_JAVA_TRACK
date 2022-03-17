package Collections;

import java.util.Arrays;
import java.util.Scanner;

public class collectionMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string :- ");
        String first_string = scanner.nextLine();
        System.out.print("Enter second string :- ");
        String second_string = scanner.nextLine();

        if(first_string.length() != second_string.length()){
            printResult(false);
        }

        char[] chars1 = first_string.toCharArray();
        char[] chars2 = second_string.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        printResult(Arrays.equals(chars1,chars2));

    }

    private static void printResult(boolean b) {
        if(b){
            System.out.println("Anagram");
        }else{
            System.out.println("Not Anagram");
        }
    }
}
