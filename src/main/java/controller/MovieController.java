package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Kontroler koji upravlja funkcionalnostima za prikaz i interakciju s filmovima.
 */

public class MovieController {
    @FXML
    private Menu Cart;
    @FXML
    private Menu Logout;
    @FXML
    private Menu Movies;

    /**
     * Metoda koja se poziva prilikom odjave korisnika.
     *
     * @param event Akcija koja je pokrenula događaj odjave.
     * @throws IOException U slučaju problema prilikom učitavanja FXML datoteke za prijavu.
     */

    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja se poziva prilikom odabira opcije "Filmovi".
     *
     * @param event Akcija koja je pokrenula događaj odabira opcije "Filmovi".
     * @throws IOException U slučaju problema prilikom učitavanja FXML datoteke za glavni izbornik.
     */

    @FXML
    void setMovies(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja se poziva prilikom odabira opcije "Korpa".
     *
     * @param event Akcija koja je pokrenula događaj odabira opcije "Korpa".
     * @throws IOException U slučaju problema prilikom učitavanja FXML datoteke za korpu.
     */

    @FXML
    void setCart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja se poziva prilikom pritiska na dugme "Završi".
     *
     * @param event Akcija koja je pokrenula događaj pritiska na dugme "Završi".
     * @throws IOException U slučaju problema prilikom učitavanja FXML datoteke za korpu.
     */
    @FXML
    void handleFinishButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();
        Scene novaScena = new Scene(root);
        Stage trenutnaPozornica = (Stage) ((Node) event.getSource()).getScene().getWindow();
        trenutnaPozornica.setScene(novaScena);
        trenutnaPozornica.show();
    }
}


