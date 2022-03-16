package Area;

public class Area_Calculation {

    public void Print(String type, int area) {
        System.out.println(type + " area is :- " + area);

    }

    public void Circle_Area(int radius) {

        int area = (2 * (22 / 7) * radius);

        Print("Circle ", area);

    }

    public void Square_Area(int side) {
        int area = side * side;

        Print("Square", area);
    }

    public void Rectangle_Area(int length, int width) {
        int area = length * width;

        Print("Rectangle", area);
    }

    public void Triangle_Area(int height, int base) {

        int area = (height * base) / 2;

        Print("Triangle", area);
    }
}
