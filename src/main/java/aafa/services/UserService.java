package aafa.services;

import aafa.data.User;
import aafa.exceptions.CouldNotWriteUsersException;
import aafa.exceptions.PasswordIncorrect;
import aafa.exceptions.UsernameAlreadyExistsException;
import aafa.exceptions.UsernameDoesNotExist;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserService {
    private static List<User> users;
    private static final Path USERS_PATH = FileSystemService.getPathToFile("config","users.json");

    public static void loadUsersFromFile() throws IOException {
        System.out.println(USERS_PATH);
       // System.out.println(AnnouncementService.class.getClassLoader().getResource("users.json"));
        if (!Files.exists(USERS_PATH)) {
            System.out.println(USERS_PATH);
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<User>>() {
        });
    }

    public static void addUser(String name,String username, String password,String phone,String address,String email, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        users.add(new User(name, username, encodePassword(username, password),phone,address, email, role));
        persistUsers();
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {

           for (User user : users) {
               if (username.equals(user.getUsername()))
                   throw new UsernameAlreadyExistsException(username);
           }

    }

    public static void verifyCredentials(String username, String password)throws UsernameDoesNotExist, PasswordIncorrect {
        boolean exists=false;
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                if (password.equals(user.getPassword())) {
                    exists=true;
                } else {
                   throw new PasswordIncorrect();

                }
            }
        }
            if (exists == false) {
                throw new UsernameDoesNotExist(username);
            }
    }
    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(USERS_PATH.toFile(), users);
        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }
    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }
    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

}
