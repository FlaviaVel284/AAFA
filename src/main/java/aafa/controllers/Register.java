package aafa.controllers;

import aafa.exceptions.UsernameAlreadyExistsException;
import aafa.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Register {

    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField addressField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Shelter Manager");
    }

    public void registerButton( ActionEvent event) throws IOException {
        try {
            UserService.addUser(nameField.getText(), usernameField.getText(),passwordField.getText(), phoneField.getText(), emailField.getText(),addressField.getText(), (String) role.getValue());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
            Parent registerFormParent = loader.load();
            Scene WelcomeScene=new Scene(registerFormParent);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(WelcomeScene);
            window.show();
        } catch (UsernameAlreadyExistsException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Username Already Exists!");
            alert.setHeaderText("Username Already Exists!");
            alert.setContentText("Please choose another username");

            alert.showAndWait();
        }
    }
}
