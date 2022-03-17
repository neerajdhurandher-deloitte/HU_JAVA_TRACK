package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input item size  :- ");
        int size = scanner.nextInt();

        List<String> list = new ArrayList<>();
        int index = 0;
        while (index < size) {
            list.add(scanner.next());
            index++;
        }

        System.out.println("Given list :- "+ list);
        Collections.reverse(list);
        System.out.println("Reverse list :- " + list);
    }
}
