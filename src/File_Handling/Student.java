package File_Handling;

public class Student {
    String studentName;
    String registrationNo10;
    String registrationNo12;
    String registrationNoBTech;
    int rank;

    public Student() {
    }

    public Student(String studentName, String registrationNo10, String registrationNo12, String registrationNoBTech, int rank) {
        this.studentName = studentName;
        this.registrationNo10 = registrationNo10;
        this.registrationNo12 = registrationNo12;
        this.registrationNoBTech = registrationNoBTech;
        this.rank = rank;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRegistrationNo10() {
        return registrationNo10;
    }

    public void setRegistrationNo10(String registrationNo10) {
        this.registrationNo10 = registrationNo10;
    }

    public String getRegistrationNo12() {
        return registrationNo12;
    }

    public void setRegistrationNo12(String registrationNo12) {
        this.registrationNo12 = registrationNo12;
    }

    public String getRegistrationNoBTech() {
        return registrationNoBTech;
    }

    public void setRegistrationNoBTech(String registrationNoBTech) {
        this.registrationNoBTech = registrationNoBTech;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
