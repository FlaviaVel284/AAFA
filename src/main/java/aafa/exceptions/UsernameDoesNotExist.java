package aafa.exceptions;

public class UsernameDoesNotExist extends Exception{
    private String username;

    public UsernameDoesNotExist(String username) {
        super(String.format("An account with the username %s does not exists! Please register!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
