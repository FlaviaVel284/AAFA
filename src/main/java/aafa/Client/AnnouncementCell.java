package aafa.Client;

import aafa.data.Announcement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class AnnouncementCell extends ListCell<Announcement> {
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

    private FXMLLoader mLLoader;

    public AnnouncementCell(){
        ownerArea=new Label("gol");
        speciesArea=new Label("");
        ageArea=new Label("");
        medicalStatusArea=new Label("");
        addressArea=new Label("");
        pictureView=new ImageView();
    }
    @Override
    protected void updateItem(Announcement announcement, boolean empty) {
        super.updateItem(announcement, empty);
        if (empty || announcement == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader();
                mLLoader.setLocation(getClass().getClassLoader().getResource("AnnouncementCell.fxml"));
                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ownerArea.setText(announcement.getOwner());
            speciesArea.setText(announcement.getSpecies());
            ageArea.setText(announcement.getAge());
            medicalStatusArea.setText(announcement.getMedicalStatus());
            addressArea.setText(announcement.getAddress());

//            try (FileInputStream input = new FileInputStream(announcement.getPathPhoto())) {
//                Image image = new Image(input);
//                pictureView.setImage(image);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            anchorPane= mLLoader.getRoot();

            setText(null);
            setGraphic(anchorPane);
        }
    }
}
