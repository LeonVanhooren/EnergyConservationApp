package Objects;

public class StudentPassword {

    private String email, password;
    private int studentID, studentenNR;
    private static int id = 0;

    public StudentPassword( String email, String password){
        this.studentID = id +1;
        id++;
        this.email = email;
        this.password = password;

    }

    public int getStudentenNR() {
        return studentenNR;
    }

    public void setStudentenNR(int studentenNR) {
        this.studentenNR = studentenNR;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}

