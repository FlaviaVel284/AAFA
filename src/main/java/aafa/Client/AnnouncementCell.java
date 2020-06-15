package aafa.Client;

import aafa.data.Announcement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
}
