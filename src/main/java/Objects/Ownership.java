package Objects;

public class Ownership {

    private String landlordID, buildingID;

    public Ownership(String landlordID, String buildingID) {
        this.landlordID = landlordID;
        this.buildingID = buildingID;
    }

    public String getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(String landlordID) {
        this.landlordID = landlordID;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    @Override
    public String toString() {
        return "Ownership{" +
                "landlordID='" + landlordID + '\'' +
                ", buildingID='" + buildingID + '\'' +
                '}';
    }
}
