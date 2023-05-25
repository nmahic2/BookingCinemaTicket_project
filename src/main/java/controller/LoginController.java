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

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

    public void login(ActionEvent e) {
        if (usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            errorLabel.setText("try again");
        } else {
            errorLabel.setText("Please enter username and password");
        }
    }
}
    //  @FXML
  //  private Button loginButton;

  /*  @FXML
    void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Provjera korisničkog imena i lozinke
        if (username.equals("nejra") && password.equals("nejra")) {
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
        } else {
            // Prikazivanje upozorenja ako korisničko ime ili lozinka nisu ispravni
            errorLabel.setText("Invalid username or password");
        }
    }

    @FXML
    private Button createAccountButton;

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

}
*/