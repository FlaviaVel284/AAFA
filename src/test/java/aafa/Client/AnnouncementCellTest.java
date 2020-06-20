package aafa.Client;

import aafa.exceptions.CouldNotWriteAnnouncemetException;
import aafa.services.AnnouncementService;
import aafa.services.FileSystemService;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AnnouncementCellTest extends ApplicationTest {
    public static final String TEST_OWNER = "testOwner";
    public static final String TEST_SPECIES = "testSpecies";
    public static final String TEST_AGE = "testAge";
    public static final String TEST_MEDICAL_STATUS = "testMedicalStatus";
    public static final String TEST_ADDRESS = "testAddress";
    public static final String TEST_PICTURE_PATH = "Images/Oskar.jpg";
    private AnnouncementCell controller;


    @BeforeClass
    public static void setUpClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = "test.addAnnouncement.AAFA";
        FileSystemService.initApplicationHomeDirIfNeeded();
        AnnouncementService.loadAnnouncementsFromFile();
    }
    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        AnnouncementService.loadAnnouncementsFromFile();

        controller = new AnnouncementCell();
        controller.ownerArea = new Label();
        controller.speciesArea = new Label();
        controller.ageArea = new Label();
        controller.addressArea = new Label();
        controller.pictureView = new ImageView();
        controller.medicalStatusArea = new Label();

        controller.ownerArea.setText(TEST_OWNER);
        controller.speciesArea.setText(TEST_SPECIES);
        controller.ageArea.setText(TEST_AGE);
        controller.addressArea.setText(TEST_ADDRESS);
        Image image= new Image(TEST_PICTURE_PATH);
        controller.pictureView.setImage(image);
        controller.medicalStatusArea.setText(TEST_MEDICAL_STATUS);
    }
    @Test
    public void testHandleAddAnnouncementActionCode() throws IOException, CouldNotWriteAnnouncemetException {
        controller.addAnnouncement();
        assertEquals(1, AnnouncementService.getAnnouncements().size());
    }
}