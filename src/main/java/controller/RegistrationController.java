package controller;
/*
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
import service.UserAccountService;


public class RegistrationController {

    @FXML
    private TextField usernameFieldRegistration;

    @FXML
    private TextField passwordFieldRegistration;
    @FXML
    private TextField lastnameFieldRegistration;
    @FXML
    private TextField firstnameFieldRegistration;
    @FXML
    private Label errorLabelRegistration;
*/

/*
    @FXML
    void loginRegistration(ActionEvent event) {
        String username = usernameFieldRegistration.getText();
        String password = passwordFieldRegistration.getText();
        String firstname = firstnameFieldRegistration.getText();
        String lastname = lastnameFieldRegistration.getText();

        // Provjera korisničkog imena i lozinke
        if (username.equals("nejra") && password.equals("nejra") && firstname.equals("nmahic2") && lastname.equals("1") ) {
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

 */
/*
    @FXML
    void register(ActionEvent event) {
        String username = usernameFieldRegistration.getText();
        String password = passwordFieldRegistration.getText();
        String firstName = firstnameFieldRegistration.getText();
        String lastName = lastnameFieldRegistration.getText();

        // Provjerite da li su sva polja popunjena
        if (username.isEmpty() || password.isEmpty() ||  firstName.isEmpty() || lastName.isEmpty()) {
            errorLabelRegistration.setText("Please fill in all fields");
            return;
        } else{
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

        // Kreirajte korisnički račun
        boolean success = UserAccountService.createUserAccount(firstName, lastName, username, password);

        if (success) {
            errorLabelRegistration.setText("Registration successful!");
            clearFields();
        } else {
            errorLabelRegistration.setText("Username already exists. Please choose a different username.");
        }
    }

    private void clearFields() {
        usernameFieldRegistration.clear();
        passwordFieldRegistration.clear();
        firstnameFieldRegistration.clear();
        lastnameFieldRegistration.clear();
    }

}*/

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
import service.UserAccountService;


public class RegistrationController extends Parent {

    @FXML
    TextField usernameFieldRegistration;

    @FXML
    TextField passwordFieldRegistration;

    @FXML
    TextField lastnameFieldRegistration;

    @FXML
    TextField firstnameFieldRegistration;

    @FXML
    Label errorLabelRegistration;

    @FXML
    private Button registration;
    private UserAccountService userAccountService; // Dodano polje

    public RegistrationController() {
        userAccountService = new UserAccountService(); // Inicijalizacija objekta
    }

    @FXML
    void register(ActionEvent event) {
        String username = usernameFieldRegistration.getText();
        String password = passwordFieldRegistration.getText();
        String firstName = firstnameFieldRegistration.getText();
        String lastName = lastnameFieldRegistration.getText();

        // Provjerite da li su sva polja popunjena
        if (username.isEmpty() || password.isEmpty() ||  firstName.isEmpty() || lastName.isEmpty()) {
            errorLabelRegistration.setText("Please fill in all fields");
            return;
        } else{
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

        // Kreirajte korisnički račun
        boolean success = userAccountService.createUserAccount(firstName, lastName, username, password); // Promjena poziva metode

        if (success) {
            errorLabelRegistration.setText("Registration successful!");
            clearFields();
        } else {
            errorLabelRegistration.setText("Username already exists. Please choose a different username.");
        }
    }

    private void clearFields() {
        usernameFieldRegistration.clear();
        passwordFieldRegistration.clear();
        firstnameFieldRegistration.clear();
        lastnameFieldRegistration.clear();
    }

}
