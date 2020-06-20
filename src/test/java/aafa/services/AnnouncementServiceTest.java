package aafa.services;

import aafa.data.Announcement;
import aafa.exceptions.CouldNotWriteAnnouncemetException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public class AnnouncementServiceTest {

    @BeforeClass
    public static void setupClass(){
        FileSystemService.APPLICATION_FOLDER="test.AAFA";
        FileSystemService.initApplicationHomeDirIfNeeded();
    }
    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }
    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        AnnouncementService.loadAnnouncementsFromFile();
        assertTrue(Files.exists(AnnouncementService.ANN_PATH));
    }
    @Test
    public void testLoadAnnouncementsFromFile() throws Exception {
        AnnouncementService.loadAnnouncementsFromFile();
        assertNotNull(AnnouncementService.getAnnouncements());
        assertEquals(0, AnnouncementService.getAnnouncements().size());
    }
    @Test
    public void testAddOneAnnouncement() throws Exception, CouldNotWriteAnnouncemetException {
        AnnouncementService.loadAnnouncementsFromFile();
        AnnouncementService.addAnnouncement("flavia","bernez","4","healthy","resita","Images/Oskar.jpg");
        assertNotNull(AnnouncementService.announcements);
        assertEquals(1, AnnouncementService.announcements.size());
    }

    @Test
    public void testAddTwoUsers() throws Exception, CouldNotWriteAnnouncemetException {
        AnnouncementService.loadAnnouncementsFromFile();
        AnnouncementService.addAnnouncement("flavia","bernez","4","healthy","resita","Images/Oskar.jpg");
        AnnouncementService.addAnnouncement("flavia2","bernez2","42","healthy2","resita2","Images/Oskar.jpg");
        assertNotNull(AnnouncementService.announcements);
        assertEquals(2, AnnouncementService.announcements.size());
    }

    @Test
    public void testAddOneAnnouncementIsPersisted() throws Exception, CouldNotWriteAnnouncemetException {
        AnnouncementService.loadAnnouncementsFromFile();
        AnnouncementService.addAnnouncement("flavia2","bernez2","42","healthy2","resita2","Images/Oskar.jpg");
        List<Announcement> announcements = new ObjectMapper().readValue(AnnouncementService.ANN_PATH.toFile(), new TypeReference<List<Announcement>>() {
        });
        assertNotNull(announcements);
        assertEquals(1, announcements.size());
    }

    @Test
    public void testAddTwoUserArePersisted() throws Exception, CouldNotWriteAnnouncemetException {
        AnnouncementService.loadAnnouncementsFromFile();
        AnnouncementService.addAnnouncement("flavia","bernez","4","healthy","resita","Images/Oskar.jpg");
        AnnouncementService.addAnnouncement("flavia2","bernez2","42","healthy2","resita2","Images/Oskar.jpg");
        List<Announcement> announcements = new ObjectMapper().readValue(AnnouncementService.ANN_PATH.toFile(), new TypeReference<List<Announcement>>() {
        });
        assertNotNull(announcements);
        assertEquals(2, announcements.size());
    }


}