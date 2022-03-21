package Main_Assignment.Database;

public class User_Object {
    private int userId;
    private String userName;
    private String password;
    private String Name;
    private int Age;
    private String companyName;
    private String designation;
    private int salary;
    private String Address;
    private String phoneNumber;

    public User_Object() {
    }

    public User_Object(int userId,String userName, String password, String name, int age, String companyName, String designation, int salary, String address, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        Name = name;
        Age = age;
        this.companyName = companyName;
        this.designation = designation;
        this.salary = salary;
        Address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
