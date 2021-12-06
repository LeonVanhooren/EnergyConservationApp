package Objects;

import java.util.Objects;

public class Building {

    private String adress, street, number, zip, city, country;
    private int buildingID;
    private static int ID=0;

    public Building(String street, String number, String zip, String city, String country){
        this.adress = street+", "+number+", "+zip+", "+city+", "+country;
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.buildingID =ID+1;
        ID++;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(int buildingID) {
        this.buildingID = buildingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return buildingID == building.buildingID && adress.equals(building.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adress, buildingID);
    }

    public String toString(){
        return this.adress+", "+this.buildingID;
    }
}

