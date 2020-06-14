package aafa.services;

import aafa.data.Announcement;
import aafa.exceptions.CouldNotWriteAnnouncemetException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AnnouncementService {
    private static List<Announcement> announcements;
    private static final Path ANN_PATH = FileSystemService.getPathToFile("new","announcement.json");

    public static void loadAnnouncementsFromFile() throws IOException {
        if (!Files.exists(ANN_PATH)) {
            FileUtils.copyURLToFile(AnnouncementService.class.getClassLoader().getResource("announcement.json"), ANN_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        announcements = objectMapper.readValue(ANN_PATH.toFile(), new TypeReference<List<Announcement>>() {
        });
    }
    public static void addAnnouncement(String owner, String species, String age, String medicalStatus, String address, String pathPhoto) throws CouldNotWriteAnnouncemetException {
        announcements.add(new Announcement(owner,  species,  age, medicalStatus, address, pathPhoto));
        persistAnnouncement();
    }
    private static void persistAnnouncement() throws  CouldNotWriteAnnouncemetException{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(ANN_PATH.toFile(),announcements);
        } catch (IOException e) {
            throw new CouldNotWriteAnnouncemetException();
        }
    }

    public static List<Announcement> getAnnouncements() {
        try {
            loadAnnouncementsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return announcements;
    }
    public static ObservableList<Announcement> getObservableList(){
        ObservableList<Announcement> announcementObservableList = FXCollections.observableArrayList();
        announcementObservableList.addAll(announcements);
        return announcementObservableList;
    }
}
