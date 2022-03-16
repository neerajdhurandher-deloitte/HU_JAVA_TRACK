package Animal;

import java.util.Scanner;

public class AnimalMain extends AnimalClass{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AnimalClass animalClass = new AnimalClass();

        System.out.print("Enter animal name :- ");
        String name = sc.nextLine();
        animalClass.setName(name);

        System.out.print("Enter animal age :- ");
        int  age = sc.nextInt();
        animalClass.setAge(age);

        System.out.print("Enter animal weight :- ");
        double weight = sc.nextDouble();
        animalClass.setWeight(weight);

        System.out.println();
        System.out.println("Animal Name :- " + animalClass.getName());
        System.out.println("Animal Age  :- " + animalClass.getAge() + " years");
        System.out.println("Animal Weight :- " + animalClass.getWeight() + " kg");

    }
}
