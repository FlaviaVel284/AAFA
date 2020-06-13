package aafa.controllers;


import aafa.data.AnimalShelter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ShelterMainScreen {
   @FXML private TableView <AnimalShelter> animalTable;
    @FXML private TableColumn <AnimalShelter, String> CodColumn;
    @FXML private TableColumn <AnimalShelter, String> SpeciesColumn;
    @FXML private TableColumn <AnimalShelter, String > AgeColumn;
    @FXML private TableColumn <AnimalShelter, String > MedicalStatusColumn;





    //this method will switch to the postAnimal scene when is pushed
    //public void postButtonPushed(ActionEvent event)
}
