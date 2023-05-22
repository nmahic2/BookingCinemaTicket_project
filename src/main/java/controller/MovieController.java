/*package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieController {
    @FXML
    private Menu Cart;
    @FXML
    private Menu Logout;
    @FXML
    private Menu Movies;
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

    @FXML
    void handleFinishButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();
        Scene novaScena = new Scene(root);
        Stage trenutnaPozornica = (Stage) ((Node) event.getSource()).getScene().getWindow();
        trenutnaPozornica.setScene(novaScena);
        trenutnaPozornica.show();
    }
    @FXML
    private TextField searchBar;

    @FXML
    void searchMovies(ActionEvent event) throws IOException {
        String searchTerm = searchBar.getText();

        // Ovdje bi trebalo pretražiti bazu filmova po imenu filma
        // Ako nađemo podudaranje, prebaciti korisnika na movie scenu
        // Ako ne nađemo podudaranje, možemo prikazati poruku o greški
        // U ovom primjeru ćemo samo prebaciti korisnika na movie scenu

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Movie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) searchBar.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private MenuButton DateAndTime;

    @FXML
    private MenuButton NumberOfTickets;
    @FXML
    private void chooseDateTime(ActionEvent event) {
        // Pripremite podatke koje želite prikazati u listi
        String movieName = "Monster house";
        String dateTime = "01.02.2023 at 14:00h";

        // Kreirajte string sa svim podacima i dodajte ga u listu
        String item = movieName + " - " + dateTime;
        ListView<Object> cartListView = null;
        cartListView.getItems().add(item);
    }

    @FXML
    private void chooseNumberOfTickets(ActionEvent event) {
        // Pripremite podatke koje želite prikazati u listi
        String movieName = "Monster house";
        String numberOfTickets = "2";

        // Kreirajte string sa svim podacima i dodajte ga u listu
        String item = movieName + " - " + numberOfTickets + " karte";
        ListView<Object> cartListView = null;
        cartListView.getItems().add(item);
    }

}
*/

package controller;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MovieController {
    @FXML
    private Menu Cart;
    @FXML
    private Menu Logout;
    @FXML
    private Menu Movies;
    @FXML
    private MenuButton DateAndTime;
    @FXML
    private MenuButton NumberOfTickets;
    @FXML
    private TextField searchBar;

    private Movie selectedMovie;
    private StringProperty selectedDateTime;
    private StringProperty selectedNumberOfTickets;

    @FXML
    void initialize() {
        selectedMovie = new Movie();
        selectedDateTime = new SimpleStringProperty("Choose Date and Time");
        selectedNumberOfTickets = new SimpleStringProperty("Choose number of tickets");
        DateAndTime.textProperty().bind(selectedDateTime);
        NumberOfTickets.textProperty().bind(selectedNumberOfTickets);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void setMovies(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void setCart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void handleFinishButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchMovies(ActionEvent event) throws IOException {
        String searchTerm = searchBar.getText();

        // Search for movies in the database based on the search term
        // In this example, we'll assume the search was successful and set the selected movie

        // Simulate a found movie
        Movie foundMovie = new Movie();
        foundMovie.setName("Monster House");

        selectedMovie.setName(foundMovie.getName());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Movie.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void chooseDateTime(ActionEvent event) {
        String movieName = selectedMovie.getName();
        String dateTime = "01.02.2023 at 14:00h";

        selectedDateTime.set(movieName + " - " + dateTime);
    }

    @FXML
    private void chooseNumberOfTickets(ActionEvent event) {
        String movieName = selectedMovie.getName();
        String numberOfTickets = "2";

        selectedNumberOfTickets.set(movieName + " - " + numberOfTickets + " karte");
    }

    public static class Movie {
        private StringProperty name;

        public Movie() {
            this.name = new SimpleStringProperty();
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }
    }


}

