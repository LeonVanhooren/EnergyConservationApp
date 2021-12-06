package Objects;

public class Contract {

    private String studentID, landlordID;

    public Contract(String studentID, String landlordID) {
        this.studentID = studentID;
        this.landlordID = landlordID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(String landlordID) {
        this.landlordID = landlordID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "studentID='" + studentID + '\'' +
                ", landlordID='" + landlordID + '\'' +
                '}';
    }
}

