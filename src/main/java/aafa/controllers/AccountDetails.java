package aafa.controllers;

import aafa.data.User;
import aafa.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AccountDetails {
    private String username;
    @FXML
    private Label Name;
    @FXML
    private Label Username;
    @FXML
    private Label Phone;
    @FXML
    private Label Email;
    @FXML
    private Label Address;
    @FXML
    private Label Role;
    @FXML
    private AnchorPane anchorPane;

    public AccountDetails(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("AccountDetails.fxml"));
        try {
            anchorPane=loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        username=LogInForm.getUsername();
        User user = UserService.getUserAs(username);
        Name.setText(user.getName());
        Username.setText(user.getUsername());
        Phone.setText(user.getPhone());
        Email.setText(user.getEmail());
        Address.setText(user.getAddress());
        Role.setText(user.getRole());
    }

}
