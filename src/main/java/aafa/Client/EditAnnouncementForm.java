package aafa.Client;

import aafa.data.Announcement;
import aafa.exceptions.CouldNotWriteAnnouncemetException;
import aafa.services.AnnouncementService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditAnnouncementForm {
    @FXML
    public TextField ownerField;
    @FXML
    public TextField speciesField;
    @FXML
    public TextField ageField;
    @FXML
    public TextField medicalStatusField;
    @FXML
    public TextField addressField;
    @FXML
    public TextField picturePathField;

    public void postButton(ActionEvent event) throws CouldNotWriteAnnouncemetException {

        Announcement ann=AnnouncementService.getAnnouncement(ownerField.getText());
        if(ownerField!=null) {
            ann.setOwner(ownerField.getText());
        }
        if(ownerField!=null) {
            ann.setSpecies(speciesField.getText());
        }
        if(ownerField!=null) {
            ann.setAge(ageField.getText());
        }
        if(ownerField!=null) {
            ann.setMedicalStatus(medicalStatusField.getText());
        }
        if(ownerField!=null) {
            ann.setAddress(addressField.getText());
        }
        if(ownerField!=null) {
        ann.setPathPhoto(picturePathField.getText());
        }
        AnnouncementService.persistAnnouncement();

        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
