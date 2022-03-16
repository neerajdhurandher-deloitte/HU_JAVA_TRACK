package Area;

import java.util.Scanner;

public class AreaClass extends Area_Calculation{

//    Create a class Area that prints the area of circle, square,
//    rectangle, triangle by passing value of sides?

    public static  Scanner sc = new Scanner(System.in);

    public  static Area_Calculation area_calculation = new Area_Calculation();

    public static void main(String[] args) {

        int shape_choice = 0;

        while (shape_choice != 5) {

            System.out.println("Select shape ");

            System.out.println("1 for Circle ");

            System.out.println("2 for Square ");

            System.out.println("3 for Rectangle ");

            System.out.println("4 for Triangle ");

            System.out.println("5 for Exit ");

            System.out.println("Enter shape choice ");

            shape_choice = sc.nextInt();

            switch (shape_choice) {

                case 1 -> CircleCalculation();
                case 2 -> SquareCalculation();
                case 3 -> RectangleCalculation();
                case 4 -> TriangleCalculation();
                case 5 -> System.out.println("Program End");
                default -> System.out.println("Please choice valid option ");

            }
        }

    }

    private static void CircleCalculation() {

        System.out.println("Enter radius of circle");

        int radius = sc.nextInt();

        area_calculation.Circle_Area(radius);

    }

    private static void SquareCalculation() {

        System.out.println("Enter side of square");

        int side = sc.nextInt();

        area_calculation.Square_Area(side);

    }

    private static void RectangleCalculation() {

        System.out.println("Enter length of rectangle");
        int length = sc.nextInt();

        System.out.println("Enter width of rectangle");
        int width = sc.nextInt();

        area_calculation.Rectangle_Area(length,width);

    }

    private static void TriangleCalculation() {

        System.out.println("Enter height of triangle");
        int height = sc.nextInt();
        System.out.println("Enter base of triangle");
        int base = sc.nextInt();

        area_calculation.Triangle_Area(height,base);

    }
}


