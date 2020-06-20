package aafa.controllers;

import aafa.services.FileSystemService;
import aafa.services.UserService;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends ApplicationTest {
    public static final String TEST_USER = "testUser";
    public static final String TEST_PASSWORD = "testPassword";
    public static final String TEST_NAME = "testName";
    public static final String TEST_PHONE = "testPhone";
    public static final String TEST_EMAIL = "testEmail";
    public static final String TEST_ADDRESS = "testAddress";
    public static final String TEST_ROLE = "testRole";
    private Register controller;
    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = "test.register.AAFA";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
    }
    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        UserService.loadUsersFromFile();

        controller = new Register();
        controller.nameField = new TextField();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.phoneField = new TextField();
        controller.emailField = new TextField();
        controller.addressField = new TextField();
        controller.role = new ChoiceBox();

        controller.nameField.setText(TEST_NAME);
        controller.passwordField.setText(TEST_PASSWORD);
        controller.usernameField.setText(TEST_USER);
        controller.phoneField.setText(TEST_PHONE);
        controller.emailField.setText(TEST_EMAIL);
        controller.addressField.setText(TEST_ADDRESS);
    }

    @Test
    public void testHandleAddUserActionCode() throws IOException {
        controller.registerButton();
        assertEquals(1, UserService.getUsers().size());
    }

}