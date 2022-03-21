package File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class File_Handling_Main {
    public static void main(String[] args) throws IOException {

        String file_path = "src/File_Handling/StudentData.csv";

        BufferedReader bufferedReader = null;
        String line = "";
        ArrayList<Student> studentList= new ArrayList<>();

        try{
            bufferedReader = new BufferedReader(new FileReader(file_path));

            int student_no = 0;

            while ((line = bufferedReader.readLine()) != null){
                String [] row = line.split(",");

                int entity_no = 0;

                String  studentName = "";
                String  registrationNo10 = "";
                String  registrationNo12 = "";
                String  registrationNoBTech = "";
                int rank = 0;

                for(String index : row){

//                    if(student_no == 2)
//                        System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" index :- " + index);

                    if(student_no > 0){

                        switch (entity_no){
                            case 1 :{
                                studentName = index;
//                                System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" name :- " + index);
                                break;
                            }
                            case 2 :{
                                registrationNo10 = index;
//                                System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" 10 :- " + index);
                                break;
                            }
                            case 3 :{
                                registrationNo12 = index;
//                                System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" 12 :- " + index);
                                break;
                            }
                            case 4 :{
                                registrationNoBTech = index;
//                                System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" btech :- " + index);
                                break;
                            }
                            case 5 :{
                                rank = Integer.parseInt(index);
//                                System.out.println("entity no :- "+entity_no+ " sn :- "+ student_no +" rank :- " + index);
                                break;
                            }
                        }

                    }
                    entity_no++;

                }

                Student temp_student = new Student(studentName,
                        registrationNo10, registrationNo12,
                        registrationNoBTech,rank);

//                System.out.println(temp_student.getStudentName());

                studentList.add(temp_student);
                studentList.sort(Comparator.comparingInt(Student::getRank));
                student_no++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            bufferedReader.close();
        }

        try{

            PrintWriter printWriter = new PrintWriter("C:\\Users\\ndhurandher\\intellij-workspace\\Oops_Assignment\\src\\File_Handling\\Result\\SelectedStudent.csv");
            StringBuilder stringBuilder= new StringBuilder();
            stringBuilder.append("Student Name");
            stringBuilder.append(",");
            stringBuilder.append("10th registration no");
            stringBuilder.append(",");
            stringBuilder.append("12th registration no");
            stringBuilder.append(",");
            stringBuilder.append("B Tech registration no");
            stringBuilder.append(",");
            stringBuilder.append("Rank");
            stringBuilder.append("\n");

            for(int i = 0;i<=5;i++) {
                addStudent(stringBuilder, studentList.get(i));
            }

            printWriter.write(stringBuilder.toString());
            printWriter.close();
            System.out.println("Done");


        }catch (Exception e){

        }

    }

    private static void addStudent(StringBuilder stringBuilder, Student student) {
        stringBuilder.append(student.getStudentName());
        stringBuilder.append(",");
        stringBuilder.append(student.getRegistrationNo10());
        stringBuilder.append(",");
        stringBuilder.append(student.getRegistrationNo12());
        stringBuilder.append(",");
        stringBuilder.append(student.getRegistrationNoBTech());
        stringBuilder.append(",");
        stringBuilder.append(student.getRank());
        stringBuilder.append("\n");


    }
}