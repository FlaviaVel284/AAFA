package aafa.Client;

import aafa.data.Announcement;
import aafa.services.AnnouncementService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientMainScreen implements Initializable {
    @FXML
    private ListView<Announcement> listView ;

    public ClientMainScreen(){
        listView=new ListView<>();
    }

    public void logOutButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        Parent registerFormParent = loader.load();
        Scene registerFormScene = new Scene(registerFormParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerFormScene);
        window.centerOnScreen();
        window.show();
    }

    public void addAnnouncementButton(ActionEvent event) throws IOException {
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
        refreshList(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnnouncementService.loadAnnouncementsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObservableList<Announcement> announcementObservableList = AnnouncementService.getObservableList();
        listView.setItems(announcementObservableList);
        listView.setCellFactory(announcementsListView -> new AnnouncementListCell());
        listView.setOrientation(Orientation.VERTICAL);
        listView.setVisible(true);
    }

    public void refreshList(ActionEvent event) {
        try {
            AnnouncementService.loadAnnouncementsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObservableList<Announcement> announcementObservableList = AnnouncementService.getObservableList();
        listView.setItems(announcementObservableList);
        listView.setCellFactory(announcementsListView -> new AnnouncementListCell());
        listView.setOrientation(Orientation.VERTICAL);
        listView.setVisible(true);
    }

}
