package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class MainMenuController<PaintRenderJob>  {
  // @FXML
  // private ImageView slika1; // pretpostavljajući da ste ID za sliku postavili na "slika1"

   // @FXML
    //javafx.scene.image.ImageView slika1;
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
    private javafx.scene.image.ImageView slika1;

    public void initialize() {
        slika1.setOnMouseClicked(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Movie.fxml"));
                Scene novaScena = new Scene(root);
                Stage stage = (Stage) slika1.getScene().getWindow();
                stage.setScene(novaScena);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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
}

