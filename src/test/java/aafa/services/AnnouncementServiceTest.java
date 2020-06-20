package aafa.services;

import aafa.data.Announcement;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnnouncementServiceTest {
    List<Announcement> announcements;
    Path ann_path= FileSystemService.getPathToFile("new","announcement.json");

//    @Before
//    public void setUp() throws Exception {
////
////        announcements.add(AnnouncementService.getAnnouncements().get(0));
////        announcements.add(AnnouncementService.getAnnouncements().get(1));
////        announcements.add(AnnouncementService.getAnnouncements().get(2));
////        announcements.add(AnnouncementService.getAnnouncements().get(3));
////        announcements.add(AnnouncementService.getAnnouncements().get(4));
////        announcements.add(AnnouncementService.getAnnouncements().get(5));
//    }

    @Test
    public void loadAnnouncementsFromFile() throws IOException {
            AnnouncementService.loadAnnouncementsFromFile();
            assertEquals(ann_path,AnnouncementService.getAnnPath());
    }

}