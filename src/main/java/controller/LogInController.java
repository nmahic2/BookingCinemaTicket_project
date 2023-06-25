
package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import service.LoginService;

/**
 * Kontroler koji upravlja funkcionalnostima prijave korisnika.
 */
public class LogInController {
    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    @FXML
    Label errorLabel;

    @FXML
    private Button loginButton;

    private LoginService loginService;

    @FXML
    private Button createAccountButton;

    /**
     * Konstruktor za LogInController.
     * Inicijalizuje LoginService koji se koristi za provjeru prijave.
     */
    public LogInController() {
        this.loginService = new LoginService();
    }

    /**
     * Metoda koja se poziva prilikom pritiska na dugme za prijavu.
     * Provjerava unesene podatke za prijavu i preusmjerava korisnika na glavni meni ako su podaci ispravni.
     *
     * @param e Akcijski događaj
     * @throws IOException U slučaju problema s učitavanjem FXML datoteke za glavni meni
     */
    public void login(ActionEvent e) throws IOException, InvalidLoginException {
        if (!usernameField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        } else {
            errorLabel.setText("Please enter username and password");
        }
    }

    /**
     * Metoda koja provjerava unesene podatke za prijavu.
     * Ako su podaci ispravni, korisnika preusmjerava na glavni meni.
     * Inače, prikazuje poruku o neispravnoj prijavi.
     *
     * @throws IOException U slučaju problema s učitavanjem FXML datoteke za glavni meni
     */
    public void validateLogin() throws IOException, InvalidLoginException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (loginService.validateLogin(username, password)) {
            errorLabel.setText("Welcome!");

            // Učitavanje FXML datoteke drugog prozora
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
            Parent root = loader.load();

            // Otvaranje nove scene s drugim prozorom
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            errorLabel.setText("Invalid login!");
            throw new InvalidLoginException("Invalid login!");
        }
    }

    /**
     * Metoda koja se poziva prilikom inicijalizacije kontrolera.
     * Postavlja akciju koja se izvršava prilikom pritiska na dugme za kreiranje korisničkog računa.
     */
    @FXML
    public void initialize() {
        createAccountButton.setOnAction(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Registration.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Korisnički definisan exception
     */
    public class InvalidLoginException extends Exception {
        public InvalidLoginException(String message) {
            super(message);
        }
    }
}

