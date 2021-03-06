package aafa.Client;

import aafa.exceptions.CouldNotWriteAnnouncemetException;
import aafa.services.AnnouncementService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


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

    public void postButton(ActionEvent event) throws CouldNotWriteAnnouncemetException {
        AnnouncementService.addAnnouncement(ownerField.getText(),speciesField.getText(),ageField.getText(),medicalStatusField.getText(),addressField.getText(),picturePathField.getText());
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
