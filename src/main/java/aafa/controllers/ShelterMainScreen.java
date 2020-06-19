package aafa.controllers;


import aafa.Client.AnnouncementForm;
import aafa.data.AnimalShelter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShelterMainScreen {
   @FXML private TableView <AnimalShelter> animalTable;
    @FXML private TableColumn <AnimalShelter, String> SpeciesColumn;
    @FXML private TableColumn <AnimalShelter, String > AgeColumn;
    @FXML private TableColumn <AnimalShelter, String > MedicalStatusColumn;


    public void logOutButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        Parent registerFormParent = loader.load();
        Scene registerFormScene = new Scene(registerFormParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerFormScene);
        window.show();
    }


    //this method will switch to the  postAnimal scene when is pushed
    public void AddButtonPushed(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("AnnouncementForm.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Announcement");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();

        }


    public void ListOfClientsButtonPushed(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("ListOfClients.fxml"));
        AnchorPane page = loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("List Of Clients");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        dialogStage.showAndWait();




    }


    }

