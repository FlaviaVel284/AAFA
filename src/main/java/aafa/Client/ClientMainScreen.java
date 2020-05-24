package aafa.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMainScreen {

    public void logOutButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("WelcomePage.fxml"));
        Parent registerFormParent = loader.load();
        Scene registerFormScene=new Scene(registerFormParent);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerFormScene);
        window.show();
    }
    public void addAnnouncementButton( ActionEvent event)throws IOException{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("AnnouncementForm.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Announcement");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(((Node)event.getSource()).getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            dialogStage.showAndWait();
    }
}
