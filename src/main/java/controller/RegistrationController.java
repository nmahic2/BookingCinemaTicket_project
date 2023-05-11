package controller;

import javafx.stage.Stage;

import java.io.IOException;

//public class LoginController { }
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField usernameFieldRegistration;

    @FXML
    private TextField passwordFieldRegistration;
    @FXML
    private TextField phoneNumberFieldRegistration;
    @FXML
    private TextField emailFieldRegistration;
    @FXML
    private Label errorLabelRegistration;

    @FXML
    void loginRegistration(ActionEvent event) {
        String username = usernameFieldRegistration.getText();
        String password = passwordFieldRegistration.getText();
        String email = emailFieldRegistration.getText();
        String phoneNumber = phoneNumberFieldRegistration.getText();

        // Provjera korisničkog imena i lozinke
        if (username.equals("nejra") && password.equals("nejra") && email.equals("nmahic2") && phoneNumber.equals("1") ) {
            try {
                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
                Parent root = loader.load();

                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}