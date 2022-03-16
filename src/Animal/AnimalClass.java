package Animal;

public class AnimalClass {
//    2.Create a class “Animal” with 3 variables as private and assign values to
//    declared variables then print them.

    private String Name;
    private int age;
    private double weight;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
