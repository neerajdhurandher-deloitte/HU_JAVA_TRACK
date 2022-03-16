package Loops;

import java.util.Scanner;

public class Loops {

    public static void printStar(int number ){
        for(int i = 0; i<number;i++){
            System.out.print("*");
        }
    }


    private static void printSpace(int number) {
        for(int i = 0; i<number;i++){
            System.out.print(" ");
        }
    }

    private static void printNextLine() {
        System.out.println();
    }


    public static void main(String[] args) {

        System.out.print("Enter number of maximum star in one row :- ");

        Scanner scanner = new Scanner(System.in);

        int max_star = scanner.nextInt();

        int pointer = 1;

        while(pointer < max_star+1){

            printSpace(max_star-pointer);
            printStar(pointer);
            printNextLine();

            pointer++;

        }

        pointer-=2;

        do {
            printSpace(max_star-pointer);
            printStar(pointer);
            printNextLine();

            pointer--;

        }while (pointer > 0);

    }
}
