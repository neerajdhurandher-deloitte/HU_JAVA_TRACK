package Arrays;

import java.util.Scanner;

public class ArrayMain {
    private  static  int count = 0;
    public static void main(String[] args) {
        count = 0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array :- ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        while (index<n){
            arr[index] = scanner.nextInt();
            index++;
        }

        calculateSubArrays(arr);
    }

    private static void calculateSubArrays(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n ;i++){

            int item = arr[i];
            check(arr[i]);

            for (int j = i+1;j<n;j++){
                item += arr[j];
                check(item);
            }
        }

        System.out.println(count);
    }
    private static void check(int data){
        if(data<0)
            count++;
    }
}
