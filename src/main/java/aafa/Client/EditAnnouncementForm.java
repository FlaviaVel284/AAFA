package aafa.Client;

import aafa.data.Announcement;
import aafa.exceptions.CouldNotWriteAnnouncemetException;
import aafa.exceptions.EnterOwnerName;
import aafa.services.AnnouncementService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditAnnouncementForm {
    private AnnouncementCell cell;
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
        Announcement ann;
       try {

           if (!ownerField.getText().equals("")) {
               ann=AnnouncementService.getAnnouncement(ownerField.getText());
               ann.setOwner(ownerField.getText());
           }else
           {
               throw new EnterOwnerName();
           }

           if (!speciesField.getText().equals("")) {
               ann.setSpecies(speciesField.getText());
           }
           if (!ageField.getText().equals("")) {
               ann.setAge(ageField.getText());
           }
           if (!medicalStatusField.getText().equals("")) {
               ann.setMedicalStatus(medicalStatusField.getText());
           }
           if (!addressField.getText().equals("")) {
               ann.setAddress(addressField.getText());
           }
           if (!picturePathField.getText().equals("")) {
               ann.setPathPhoto(picturePathField.getText());
           }

           AnnouncementService.persistAnnouncement();
           ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
       }catch(EnterOwnerName e){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Please enter owner name!");
           alert.setHeaderText("Please enter owner name!");
           alert.setContentText("Please enter owner name!");
           System.out.println();
           alert.showAndWait();
       }
    }

}
