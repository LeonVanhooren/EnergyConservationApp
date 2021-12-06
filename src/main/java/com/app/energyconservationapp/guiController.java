package com.app.energyconservationapp;

import Objects.*;
import databaseTest.dbTest;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.util.ArrayList;

public class guiController {
    @FXML
    private TextField studentUsernameInput,landlordUsernameInput;
    @FXML
    private PasswordField studentPasswordInput, landlordPasswordInput;

    @FXML
    private Button studentSignIn, landlordSignIn, signOutButton;

    dbTest dbStream = new dbTest();
    private ArrayList<Student> students;
    private ArrayList<Landlord> landlords;
    private ArrayList<Building> buildings;
    private ArrayList<Ownership> ownerships;
    private ArrayList<Contract> contracts;
    private ArrayList<Room> rooms;
    private ArrayList<Lease> leases;
    private ArrayList<Appliance> appliances;
    private ArrayList<BelongsTo> belongsToArrayList;
    private ArrayList<Contains> containsArrayList;

    public guiController(){
        students = dbStream.databaseReadStudent();
        landlords = dbStream.databaseReadLandlord();
        rooms = dbStream.databaseReadRoom();
        leases = dbStream.databaseReadLease();
        buildings = dbStream.databaseReadBuilding();
        appliances = dbStream.databaseReadAppliance();
        belongsToArrayList = dbStream.databaseReadBelongsTo();
        containsArrayList = dbStream.databaseReadContains();
        contracts = dbStream.databaseReadContract();
        ownerships = dbStream.databaseReadOwnership();
    }


    public boolean checkStudent(String username, String password){
        return true;
    }

    public boolean studentPresent(String studentID, String password){
        for(Student newStudent:students){
            if(newStudent.getStudentID().equals(studentID)&&newStudent.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    private Stage stage;
    private Parent root;
    private Scene scene;

    public void studentSignIn(ActionEvent event) throws IOException {
        String[] outputStudent = new String[2];

        outputStudent[0] = studentUsernameInput.getText();
        outputStudent[1] = studentPasswordInput.getText();

        if(studentPresent(outputStudent[0],outputStudent[1] )==true){
            System.out.println("zit in de database");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("studentMenuGui.fxml"));
            root = loader.load();


            guiController output = loader.getController();
            output.setUsername(outputStudent[0]);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Student menu");
            scene = new Scene(root);
            stage.setScene(scene);

        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorNotInDB.fxml"));
            root = loader.load();


            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Error");
            scene = new Scene(root);
            stage.setScene(scene);


        }

        /*System.out.println(outputStudent[0]+" "+outputStudent[1]);
        System.out.println(students);
        System.out.println(landlords);
        System.out.println(rooms);
        System.out.println(leases);
        System.out.println(buildings);
        System.out.println(appliances);
        System.out.println(belongsToArrayList);
        System.out.println(containsArrayList);
        System.out.println(contracts);
        System.out.println(ownerships);*/

    }

    @FXML
    Label usernameLabel;

    public void setUsername(String username){            usernameLabel.setText("Welcome: "+username);

    }

    public void backToSignIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginGUI.fxml"));
        root = loader.load();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Sign in menu");
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public void landlordSignIn(){

    }
}
