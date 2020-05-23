package aafa.controllers;

import aafa.MainApp;
import aafa.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController  {

    public void handleRegister( ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("Register.fxml"));
        Parent registerFormParent = loader.load();
        Scene registerFormScene=new Scene(registerFormParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerFormScene);
        window.show();
    }

    public void handleLogIn(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("LogInForm.fxml"));
        Parent registerFormParent = loader.load();
        Scene registerFormScene=new Scene(registerFormParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerFormScene);
        window.show();
    }


}