package Objects;


public class LandlordPassword {

    private String email, password;
    private int landlordID;
    private static int id = 0;

    public LandlordPassword( String email, String password){
        this.landlordID = id +1;
        id++;
        this.email = email;
        this.password = password;

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

    public int getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(int studentID) {
        this.landlordID = studentID;
    }
}

