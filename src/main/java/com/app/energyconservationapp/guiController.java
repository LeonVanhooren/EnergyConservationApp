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

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class guiController {
    @FXML
    private TextField studentUsernameInput;
    @FXML
    private PasswordField studentPasswordInput;


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
    private Student currentStudent;
    private Landlord currentLandlord;

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
        currentStudent = null;
    }
    @FXML
    private TextField firstNameStudent;
    @FXML
    private TextField lastNameStudent;
    @FXML
    private TextField emailStudent;
    @FXML
    private TextField passwordStudent1;
    @FXML
    private TextField passwordStudent2;

    @FXML
    private Label registerInfoStudent;
    @FXML
    private Label studentNumber;
    @FXML
    private Label passwordMatching;


    public void studentRegister(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("registerStudentGUI.fxml"));
        root = loader.load();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student register menu");
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public void studentRegisterButton(){
        String firstName, lastName, email, password1, password2;
        firstName = firstNameStudent.getText();
        lastName = lastNameStudent.getText();
        email = emailStudent.getText();
        password1 = passwordStudent1.getText();
        password2 = passwordStudent2.getText();

        if(studentPresentRegister(firstName, lastName, email)==false){

            if(!password1.equals(password2)){
                passwordStudent1.setText("");
                passwordStudent2.setText("");
            }
            else{


                int studentNR = (int)Math.floor(Math.random()*(999999-910000+1)+910000);
                String studentNRstring = "01"+studentNR;

                Student newStudent = new Student(firstName, lastName, email, studentNRstring, password1);

                dbStream.addStudentToDatabase(newStudent);

                studentNumber.setText("Your studentnr. is "+studentNRstring+" remember this well!");
                registerInfoStudent.setText("The student is successfully registered!");
            }

        }
        else{
            registerInfoStudent.setText("The database already contains this student!");
        }

        if(password1.equals(password2)){
            passwordMatching.setText("The passwords match!");
        }
        else{passwordMatching.setText("The passwords do not match!");}

    }

    public void clearStudentInput(){
        firstNameStudent.setText("");
        lastNameStudent.setText("");
        emailStudent.setText("");
        passwordStudent2.setText("");
        passwordStudent1.setText("");
        passwordMatching.setText("");
    }

    public boolean studentPresentRegister(String firstname, String lastName, String email){
        for(Student newStudent:students){
            if(newStudent.getFirstName().equals(firstname)&&newStudent.getLastName().equals(lastName)&&newStudent.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }


    @FXML
    private TextField firstNameLandlord;
    @FXML
    private TextField lastNameLandlord;
    @FXML
    private TextField emailLandlord;
    @FXML
    private TextField telephoneNrLandlord;
    @FXML
    private PasswordField passwordLandlord1;
    @FXML
    private PasswordField passWordLandlord2;

    @FXML
    private Label registerInfoLandlord;
    @FXML
    private Label landlordIDLabel;
    @FXML
    private Label passwordMatchingLandlord;


    public void landlordRegister(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("registerLandlordGUI.fxml"));
        root = loader.load();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Landlord register menu");
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void landlordRegisterButton(){
        String firstName, lastName, email,telephoneNr, password1, password2;
        firstName = firstNameLandlord.getText();
        lastName = lastNameLandlord.getText();
        email = emailLandlord.getText();
        password1 = passwordLandlord1.getText();
        password2 = passWordLandlord2.getText();
        telephoneNr = telephoneNrLandlord.getText();

        if(landlordPresentRegister(firstName, lastName, email, telephoneNr)==false){

            if(!password1.equals(password2)){
                passwordLandlord1.setText("");
                passWordLandlord2.setText("");
            }
            else{


                int landlordID = (int)Math.floor(Math.random()*(999-100+1)+999);
                String landlordIDstring = "1"+landlordID;

                Landlord newLandlord = new Landlord(landlordIDstring, firstName, lastName, email, telephoneNr, password1);

                dbStream.addLandlordToDatabase(newLandlord);

                landlordIDLabel.setText("Your landlord ID is "+landlordID+" remember this well!");
                registerInfoLandlord.setText("The landlord is successfully registered!");
            }

        }
        else{
            registerInfoLandlord.setText("The database already contains this landlord!");
        }

        if(password1.equals(password2)){
            passwordMatchingLandlord.setText("The passwords match!");
        }
        else{passwordMatchingLandlord.setText("The passwords do not match!");}

    }

    public void clearLandlordInput(){
        firstNameLandlord.setText("");
        lastNameLandlord.setText("");
        emailLandlord.setText("");
        passwordLandlord1.setText("");
        passWordLandlord2.setText("");
        passwordMatchingLandlord.setText("");
        telephoneNrLandlord.setText("");
    }

    public boolean landlordPresentRegister(String firstname, String lastName, String email, String telephoneNr){
        for(Landlord newLandlord:landlords){
            if(newLandlord.getFirstName().equals(firstname)&&newLandlord.getLastName().equals(lastName)&&newLandlord.getEmail().equals(email)&&newLandlord.getTelephoneNR().equals(telephoneNr)){
                return true;
            }
        }
        return false;
    }



    public boolean studentPresent(String studentID, String password){
        for(Student newStudent:students){
            if(newStudent.getStudentID().equals(studentID)&&newStudent.getPassword().equals(password)){
                currentStudent = newStudent;
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
            output.setUsername(currentStudent.getName());
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

    }

    public void applianceMenu(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("applianceMenu.fxml"));
        root = loader.load();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Appliance menu");
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public void landlordMenu(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("landlordMenu.fxml"));
        root = loader.load();

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("landlord menu");
        scene = new Scene(root);
        stage.setScene(scene);

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

    public void backToStudentMenu(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("studentMenu.fxml"));
        root = loader.load();

        guiController output = loader.getController();
        output.setUsername(currentStudent.getName());

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Student menu");
        scene = new Scene(root);
        stage.setScene(scene);

    }
    @FXML
    private TextField  QRCodeTF;
    @FXML
    private TextField applianceIDTF;
    @FXML
    private TextField consumptionTF;
    @FXML
    private TextField efficiencyTF;
    @FXML
    private Label addApplianceLabel;

    public void addAppliance(ActionEvent event){
        String applianceID, consumption, efficiency, QRCode;

        applianceID = applianceIDTF.getText();
        consumption = consumptionTF.getText();
        efficiency = efficiencyTF.getText();
        QRCode = QRCodeTF.getText();

        if(appliancePresent(applianceID)==true){
            setAddApplianceStatus("The database already contains this appliance!");
        }
        else{
            Appliance newAppliance = new Appliance(applianceID, consumption, efficiency, QRCode);
            dbStream.addApplianceToDatabase(newAppliance);

            setAddApplianceStatus("The appliance is added to the database!");

        }

    }

    public boolean appliancePresent(String applianceID){
        for(Appliance newAppliance:appliances){
            if(newAppliance.getApplianceID().equals(applianceID)){
                return true;
            }
        }
        return false;
    }



    public void setAddApplianceStatus(String output){
        addApplianceLabel.setText(output);

    }

    public void landlordSignIn(ActionEvent event) throws IOException{
        String[] outputStudent = new String[2];

        outputStudent[0] = studentUsernameInput.getText();
        outputStudent[1] = studentPasswordInput.getText();

        if(studentPresent(outputStudent[0],outputStudent[1] )==true){
            System.out.println("zit in de database");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("studentMenuGui.fxml"));
            root = loader.load();


            guiController output = loader.getController();
            output.setUsername(currentStudent.getName());
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


    }

    public boolean landlordPresent(String landlordID, String password){
        for(Landlord newLandlord:landlords){
            if(newLandlord.getLandlordID().equals(landlordID)&&newLandlord.getPassWord().equals(password)){
                currentLandlord = newLandlord;
                return true;

            }
        }
        return false;
    }


}
