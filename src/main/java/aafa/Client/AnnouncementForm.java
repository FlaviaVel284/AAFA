package aafa.Client;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class AnnouncementForm {
    @FXML
    private TextField ownerField;
    @FXML
    private TextField speciesField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField medicalStatusField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField picturePathField;

    public void postButton(ActionEvent event) {
    }
}
