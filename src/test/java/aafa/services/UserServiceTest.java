package aafa.services;

import aafa.data.User;
import aafa.exceptions.UsernameAlreadyExistsException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = "test.AAFA";
        FileSystemService.initApplicationHomeDirIfNeeded();
        //UserService.loadUsersFromFile();
    }

    @Before
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
    }

    @Test
    public void testCopyDefaultFileIfNotExists() throws Exception {
        UserService.loadUsersFromFile();
        assertTrue(Files.exists(UserService.USERS_PATH));
    }

    @Test
    public void testloadUsersFromFile() throws Exception{
        UserService.loadUsersFromFile();
        assertNotNull(UserService.users);
        assertEquals(0, UserService.users.size());
    }

    @Test
    public void testAddOneUser() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test", "testPass", "432", "123", "timi", "testare", "Client");
        assertNotNull(UserService.users);
        assertEquals(1, UserService.users.size());
    }

    @Test
    public void testAddTwoUsers() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test1", "testPass1", "123", "456", "resita", "testare1", "Client");
        UserService.addUser("test2", "testPass2", "456", "789", "arad", "testare2", "Shelter Manager");
        assertNotNull(UserService.users);
        assertEquals(2, UserService.users.size());
    }


    @Test
    public void testAddOneUserIsPersisted() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test", "testPass", "432", "123", "timi", "testare", "Client");
        List<User> users = new ObjectMapper().readValue(UserService.USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void testAddTwoUserArePersisted() throws Exception {
        UserService.loadUsersFromFile();
        UserService.addUser("test1", "testPass1", "123", "456", "resita", "testare1", "Client");
        UserService.addUser("test2", "testPass2", "432", "789", "arad", "testare2", "Shelter Manager");
        List<User> users = new ObjectMapper().readValue(UserService.USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
        assertNotNull(users);
        assertEquals(2, users.size());
    }


    @Test
    public void testPasswordEncoding() {
        assertNotEquals("testPass1", UserService.encodePassword("username1", "testPass1"));
    }
}