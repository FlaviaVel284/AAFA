package aafa.Client;

import aafa.data.Announcement;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class AnnouncementListCell extends ListCell<Announcement> {
    private final AnnouncementCell announcementCell=new AnnouncementCell();
    private final Node view= announcementCell.getView();

    @Override
    protected void updateItem(Announcement item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            setGraphic(null);
        }else{
            announcementCell.setAnnouncement(item);
            setGraphic(view);
        }
    }
}
