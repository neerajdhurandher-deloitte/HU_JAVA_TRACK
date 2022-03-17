package String;

import java.util.Scanner;

public class StringMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string :- ");
        String first_str = scanner.nextLine();
        System.out.print("Enter second string :- ");
        String second_str = scanner.nextLine();
        System.out.print("Enter shuffle string :- ");
        String shuffle_str = scanner.nextLine();

        String valid_str = "";

        int i = 0;
        int j = 0;
        boolean first = false;
        boolean second = true;

        while(i<first_str.length() && j<second_str.length()){

            if(first){
                valid_str += String.valueOf(first_str.charAt(i));
                i++;
                first = false;
                second = true;
            }
            else if(second){
                valid_str += String.valueOf(second_str.charAt(j));
                j++;
                first = true;
                second = false;
            }
        }

        while (i<first_str.length()){
            valid_str+= String.valueOf(first_str.charAt(i));
            i++;
        }
        while (j<second_str.length()){
            valid_str+= String.valueOf(first_str.charAt(j));
            j++;
        }


//        System.out.println(valid_str);

        if(valid_str.equals(shuffle_str)){
            System.out.println("Valid Input");
        }else{
            System.out.println("Invalid Input");
        }


    }
}
