package aafa.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ListOfClients {
    public void backButton( ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("ShelterMainScreen.fxml"));
        Parent registerFormParent = loader.load();
        Scene WelcomeScene=new Scene(registerFormParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(WelcomeScene);
        window.show();
    }
}
