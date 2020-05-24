package aafa.controllers;

import aafa.exceptions.PasswordIncorrect;
import aafa.exceptions.UsernameDoesNotExist;
import aafa.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInForm {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void logInButton( ActionEvent event) throws IOException {

        try {
            String encodedPassword=UserService.encodePassword(usernameField.getText(), passwordField.getText());
            UserService.verifyCredentials(usernameField.getText(),encodedPassword);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("ClientMainScreen.fxml"));
            Parent registerFormParent = loader.load();
            Scene WelcomeScene=new Scene(registerFormParent);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.centerOnScreen();
            window.setScene(WelcomeScene);
            window.show();
        }  catch (PasswordIncorrect e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect Password!");
            alert.setHeaderText("Incorrect Password!");
            alert.setContentText("Please rewrite the password!");

            alert.showAndWait();
        } catch (UsernameDoesNotExist e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Username Does Not Exist!");
            alert.setHeaderText("Username Does Not Exist!");
            alert.setContentText("Please register first");

            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
            Parent registerFormParent = loader.load();
            Scene WelcomeScene=new Scene(registerFormParent);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(WelcomeScene);
            window.show();
        }
    }
    public void backButton( ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        Parent registerFormParent = loader.load();
        Scene WelcomeScene=new Scene(registerFormParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(WelcomeScene);
        window.show();
    }
}
