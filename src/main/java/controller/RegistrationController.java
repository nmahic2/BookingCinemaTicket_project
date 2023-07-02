package controller;

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


/**
 * Kontroler koji upravlja procesom registracije korisnika.
 */
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

    /**
     * Konstruktor klase RegistrationController.
     * Inicijalizira objekat UserAccountService koji se koristi za kreiranje korisničkih računa.
     */
    public RegistrationController() {
        userAccountService = new UserAccountService();
    }

    /**
     * Metoda koja se poziva prilikom klika na dugme za registraciju.
     * Vrši validaciju unesenih podataka, kreira korisnički račun i otvara novu scenu nakon uspješne registracije.
     *
     * @param event Događaj koji je pokrenuo metodu.
     */
    @FXML
    void register(ActionEvent event) {
        String username = usernameFieldRegistration.getText();
        String password = passwordFieldRegistration.getText();
        String firstName = firstnameFieldRegistration.getText();
        String lastName = lastnameFieldRegistration.getText();

        // Provjerite da li su sva polja popunjena
        if (username.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            errorLabelRegistration.setText("Please fill in all fields");
            return;
        }

        // Provjerite postojanje korisnika s unesenim korisničkim imenom
        boolean usernameExists = userAccountService.findByUsername(username);
        if (usernameExists) {
            errorLabelRegistration.setText("Username already exists. Please choose a different username.");
            return;
        }

        // Kreirajte korisnički račun
        boolean success = userAccountService.createUserAccount(firstName, lastName, username, password); // Promjena poziva metode

        if (success) {
            errorLabelRegistration.setText("Registration successful!");
            clearFields();

            try {
                // Učitavanje FXML datoteke drugog prozora
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
                Parent root = loader.load();

                // Otvaranje nove scene s drugim prozorom
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

                // Zatvaranje trenutne scene za registraciju
                Stage currentStage = (Stage) registration.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            errorLabelRegistration.setText("Error occurred. Please try again.");
        }

    }

    /**
     * Metoda koja briše sadržaj svih tekstualnih polja za unos.
     */
    private void clearFields() {
        usernameFieldRegistration.clear();
        passwordFieldRegistration.clear();
        firstnameFieldRegistration.clear();
        lastnameFieldRegistration.clear();
    }

}
