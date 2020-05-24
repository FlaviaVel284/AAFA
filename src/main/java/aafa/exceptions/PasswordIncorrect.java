package aafa.exceptions;

public class PasswordIncorrect extends Exception {

    public PasswordIncorrect() {
        super(String.format("The password is incorrect!"));
    }
}
