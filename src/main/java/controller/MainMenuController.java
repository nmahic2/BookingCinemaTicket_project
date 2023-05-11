package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
        import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {
  // @FXML
  // private ImageView slika1; // pretpostavljajući da ste ID za sliku postavili na "slika1"

    @FXML
    javafx.scene.image.ImageView slika1;
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
    private void handleClickOnImage() throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Movie.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slika1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    handleClickOnImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

