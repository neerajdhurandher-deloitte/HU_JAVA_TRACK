package Main_Assignment.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DB_Operations {

    private ArrayList<User_Object> userListGlobal = new ArrayList<>();
    private String currentUserName = null;
    private User_Object current_user_object;

    public DB_Operations() throws IOException {
    }

    public int getUserListSize(){
        return this.userListGlobal.size();
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String  currentUserName) {
        this.currentUserName = currentUserName;
    }

    public User_Object getCurrent_user_object() {
        return current_user_object;
    }

    private void setCurrent_user_object(User_Object current_user_object) {
        this.current_user_object = current_user_object;
    }

    public void readDB() throws IOException {

        String file_path = "src/Main_Assignment/Database/UserDatabase.csv";

        BufferedReader bufferedReader = null;
        String line = "";
        ArrayList<User_Object> userList= new ArrayList<>();

        try{
            bufferedReader = new BufferedReader(new FileReader(file_path));

            int currentUserSerialNo = 0;

            while ((line = bufferedReader.readLine()) != null){
                String [] row = line.split(",");

                int entity_no = 1;

                int userId = 0;
                String userName = "";
                String  password = "";
                String  name = "";
                int age = 0;
                String  company_name = "";
                String designation ="";
                int salary = 0;
                String address = "";
                String phoneNumber = "";


                for(String index : row){

//                    System.out.println(entity_no + " " +index);

//                    if(currentUserSerialNo == 3)
//                        System.out.println("entity no :- "+entity_no+ " sn :- "+ currentUserSerialNo +" index :- " + index);

                    if(currentUserSerialNo > 0){

                        switch (entity_no) {
                            case 1 -> {
                                userId = Integer.parseInt(index);
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " userId :- " + index);
                            }
                            case 2 -> {
                                userName = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " userName :- " + index);
                            }
                            case 3 -> {
                                password = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " password :- " + index);
                            }

                            case 4 -> {
                                name = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " name :- " + index);
                            }
                            case 5 -> {
                                age = Integer.parseInt(index);
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " age :- " + index);
                            }
                            case 6 -> {
                                company_name = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " company_name :- " + index);
                            }
                            case 7 -> {
                                designation = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " designation :- " + index);
                            }
                            case 8 -> {
                                salary = Integer.parseInt(index);
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " salary :- " + index);
                            }
                            case 9 -> {
                                address = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " address :- " + index);
                            }
                            case 10 -> {
                                phoneNumber = index;
//                                System.out.println("entity no :- " + entity_no + " sn :- " + currentUserSerialNo + " phoneNumber :- " + index);
                            }
                        }

                    }

                    entity_no++;

                }

                User_Object add_user = new User_Object();

                add_user.setUserId(userList.size()+1);
                add_user.setPassword(password);
                add_user.setName(name);
                add_user.setAge(age);
                add_user.setCompanyName(company_name);
                add_user.setDesignation(designation);
                add_user.setSalary(salary);
                add_user.setAddress(address);
                add_user.setPhoneNumber(phoneNumber);



                userList.add(add_user);

                if(currentUserName != null){
                    if(currentUserName.equals(userName)){
                        System.out.println("set user");
                        setCurrent_user_object(add_user);
                    }
                }
//                printUser(add_user);

                currentUserSerialNo++;
            }

            userListGlobal = userList;

            for (User_Object user_object : userList){
                printUser(user_object);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
        }

    }

    public void addUser(User_Object user) {

        try {

            PrintWriter printWriter = new PrintWriter("src/Main_Assignment/Database/UserDatabase.csv");
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(user.getUserId());
            stringBuilder.append(",");
            stringBuilder.append(user.getPassword());
            stringBuilder.append(",");
            stringBuilder.append(user.getName());
            stringBuilder.append(",");
            stringBuilder.append(user.getAge());
            stringBuilder.append(",");
            stringBuilder.append(user.getCompanyName());
            stringBuilder.append(",");
            stringBuilder.append(user.getDesignation());
            stringBuilder.append(",");
            stringBuilder.append(user.getSalary());
            stringBuilder.append(",");
            stringBuilder.append(user.getAddress());
            stringBuilder.append(",");
            stringBuilder.append(user.getPhoneNumber());

            stringBuilder.append("\n");


            printWriter.write(stringBuilder.toString());
            printWriter.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                readDB();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getUserDetails(){
        printUser(current_user_object);
    }

    public void printUser(User_Object user_object){

        System.out.println("1.User-ID:  "+user_object.getUserId());
        System.out.println("2.Name: "+user_object.getName());
        System.out.println("3.Age: "+user_object.getAge());
        System.out.println("4.Company Name: "+user_object.getCompanyName());
        System.out.println("5. Designation: "+user_object.getDesignation());
        System.out.println("6. Salary: "+user_object.getSalary());
        System.out.println("7. Address: "+user_object.getAddress());
        System.out.println("7. Phone Number: "+user_object.getPhoneNumber());

    }

}
