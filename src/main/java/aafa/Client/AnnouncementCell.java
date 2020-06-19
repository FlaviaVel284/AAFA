package aafa.Client;

import aafa.controllers.LogInForm;
import aafa.data.Announcement;
import aafa.data.User;
import aafa.exceptions.CouldNotWriteAnnouncemetException;
import aafa.services.AnnouncementService;
import aafa.services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AnnouncementCell {

    private Announcement announcement;

    @FXML
    private Label ownerArea;
    @FXML
    private Label speciesArea;
    @FXML
    private Label ageArea;
    @FXML
    private Label medicalStatusArea;
    @FXML
    private Label addressArea;
    @FXML
    private ImageView pictureView;
    @FXML
    private AnchorPane anchorPane;

    public AnnouncementCell(){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("AnnouncementCell.fxml"));
            loader.setController(this);
            try {
                anchorPane=loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void setAnnouncement(Announcement announcement){
        ownerArea.setText(announcement.getOwner());
        speciesArea.setText(announcement.getSpecies());
        ageArea.setText(announcement.getAge());
        medicalStatusArea.setText(announcement.getMedicalStatus());
        addressArea.setText(announcement.getAddress());
        String picture=announcement.getPathPhoto();
        Image image= new Image(picture);
        pictureView.setImage(image);
    }

    public Node getView() {
        return anchorPane ;
    }

    public void editAnnouncement(ActionEvent event) throws IOException {
        String username=LogInForm.getUsername();
        User user = UserService.getUserAs(username);
        String name=user.getName();
        if(name.equals(this.ownerArea.getText())){
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getClassLoader().getResource("EditAnnouncementForm.fxml"));
           AnchorPane page = loader.load();

           Stage dialogStage = new Stage();
           dialogStage.setTitle("Edit Announcement");
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);

           dialogStage.showAndWait();
       }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Not your announcement!");
                alert.setHeaderText("Not your announcement!");
                alert.setContentText("You can only edit you own announcements");

                alert.showAndWait();
            }
    }
    public void deleteButton(ActionEvent event) throws CouldNotWriteAnnouncemetException {
        AnnouncementService.deleteAnnouncement(ownerArea.getText(),speciesArea.getText(),ageArea.getText(),medicalStatusArea.getText(),addressArea.getText());
    }
}

