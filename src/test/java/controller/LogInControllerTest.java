/*package controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogInControllerTest {
    @Test
    public void login() {

}
    @Test
    public void validateLogin() {
    }

    @Test
    public void initialize() {
    }
}*/package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInControllerTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    public void testLoginWithValidCredentials() {
        // Pronađite elemente grafičkog korisničkog interfejsa
        TextField usernameField = lookup("#usernameField").query();
        PasswordField passwordField = lookup("#passwordField").query();
        Button loginButton = lookup("#loginButton").query();
        Label errorLabel = lookup("#errorLabel").query();

        // Postavite vrednosti za polja
        usernameField.setText("nmahic2");
        passwordField.setText("123456");


    }

    @Test
    public void testLoginWithEmptyFields() {
        // Pronađite elemente grafičkog korisničkog interfejsa
        Button loginButton = lookup("#loginButton").query();
        Label errorLabel = lookup("#errorLabel").query();

        // Ostavite polja prazna

        // Kliknite na dugme za prijavu
        clickOn(loginButton);

        // Proverite očekivane rezultate
        assertEquals("Please enter username and password", errorLabel.getText());
    }
}
