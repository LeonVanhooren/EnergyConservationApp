package com.app.energyconservationapp;

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
import java.awt.event.ActionEvent;
import java.io.IOException;

public class loginController{

    @FXML
    private TextField studentUsernameInput,landlordUsernameInput;
    @FXML
    private PasswordField studentPasswordInput, landlordPasswordInput;

    @FXML
    private Button landlordSignInButton;
    @FXML
    private Button studentSignInButton;


    String[] outputLandlord = new String[2];
    private Stage stage;
    private Scene scene;
    private Parent root;
    private App app = new App();

    public void studentSignIn(Event actionEvent) throws IOException {
        String[] outputStudent = new String[2];

            outputStudent[0] = studentUsernameInput.getText();
            outputStudent[1] = studentPasswordInput.getText();
            if(app.checkStudent(studentUsernameInput.getText(), studentPasswordInput.getText())==true){
                System.out.println(outputStudent[0]+" "+outputStudent[1]);
                switchToSceneStudentMenu(actionEvent);
            }
            else{
                studentSignIn(actionEvent);
            }




       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("studentMenuGui.fxml"));
        root = loader.load();


        studentMenuController output = loader.getController();
        output.setUsername(outputStudent[0]);
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);*/
    }

    public String[] landlordSignIn(javafx.event.ActionEvent actionEvent) {
        try{
            outputLandlord[0] = landlordUsernameInput.getText();
            outputLandlord[1] = landlordPasswordInput.getText();
        }
        catch (Exception exception){
            System.out.println(exception);
        }
        return outputLandlord;
    }

    public void switchToSceneStudentMenu(Event event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("studentMenuGui.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Student Menu");
        stage.setScene(scene);
        stage.show();

    }

    public void signOutButoon(Event event){


    }


}