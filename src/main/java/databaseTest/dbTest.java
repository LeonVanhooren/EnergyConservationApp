package databaseTest;

import Objects.*;

import java.sql.*;
import java.util.ArrayList;

public class dbTest {
    private static Connection CON = null;
    private static String USERNAME = "db2021_23";
    private static String PASSWORD = "61928534c4248";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://pdbmbook.com:3306/db2021_23";
    public ArrayList<Student> databaseReadStudent(){
        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database");
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from student");
            System.out.println("studentID\t\tfirstname\t\tlastname\t\temail");
            while (rs.next()) {

                String id = rs.getString("studentID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Student newStudent = new Student(firstname, lastname, email, id, password);
                students.add(newStudent);

            }

        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
        return students;
    }

    public ArrayList<Landlord> databaseReadLandlord(){
        ArrayList<Landlord> landlords = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from landlord");
            while (rs.next()) {

                String id = rs.getString("landlordID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String telephoneNr = rs.getString("telephoneNr");
                String password = rs.getString("password");
                Landlord newLandlord = new Landlord(id, firstname, lastname, email, telephoneNr, password);
                landlords.add(newLandlord);

            }

        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
        return landlords;
    }

    public ArrayList<Room> databaseReadRoom(){
        ArrayList<Room> rooms = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from room");
            while (rs.next()) {

                int roomNr = Integer.parseInt(rs.getString("roomNr"));
                String roomID = rs.getString("roomID");
                String buildingID = rs.getString("buildingID");
                String characteristics = rs.getString("characteristics");

                Room newRoom = new Room(characteristics, buildingID, roomNr, roomID);
                rooms.add(newRoom);

            }

        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
        return rooms;
    }

    public ArrayList<Lease> databaseReadLease(){
        ArrayList<Lease> leases = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from rents");
            while (rs.next()) {

                String studentID = rs.getString("studentID");
                String roomID = rs.getString("roomID");

                Lease newLease = new Lease(studentID, roomID);
                leases.add(newLease);

            }

        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
        return leases;
    }

    public ArrayList<Ownership> databaseReadOwnership(){
        ArrayList<Ownership> ownerships = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("select * from rents");
            while (rs.next()) {

                String landlordID = rs.getString("landlordID");
                String buildingID = rs.getString("buildingID");

                Ownership newOwnership = new Ownership(landlordID, buildingID);
                ownerships.add(newOwnership);

            }

        } catch (SQLException e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
        return ownerships;
    }


}
