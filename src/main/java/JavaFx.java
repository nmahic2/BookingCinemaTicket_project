
package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Klasa JavaFx predstavlja glavnu ulaznu tačku za JavaFX aplikaciju.
 * Ona proširuje Application klasu i definiše metodu start(),
 * koja konfiguriše JavaFX prozor i scenu učitavanjem FXML datoteke
 * i prikazivanjem na prozoru.
 */
public class JavaFx extends Application {

    /**
     * Metoda start() se poziva kada se JavaFX aplikacija pokreće.
     * Ona učitava FXML datoteku za prikaz log-in ekrana, kreira novu scenu
     * sa učitanim korijenskim čvorom iz FXML-a, postavlja scenu na prozor
     * i prikazuje prozor.
     *
     * @param stage primarni prozor za JavaFX aplikaciju
     * @throws Exception ako se desi greška prilikom učitavanja FXML datoteke
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda main() predstavlja ulaznu tačku za JavaFX aplikaciju.
     * Ona pokreće JavaFX aplikaciju pozivajući metodu launch() sa argumentima
     * komandne linije.
     *
     * @param args argumenti komandne linije
     */
    public static void main(String[] args) {
        launch(args);
    }

}