
package repository;

import javafx.scene.control.Alert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Repozitorij za upravljanje podacima korisničkih računa u bazi podataka.
 */
public class UserAccountRepository {
    /**
     * Datoteka konfiguracije baze podataka.
     */
    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    /**
     * Ključ za naziv baze podataka u konfiguracijskoj datoteci.
     */
    private static final String PROPERTY_DB_NAME = "db.name";
    /**
     * Ključ za korisnika baze podataka u konfiguracijskoj datoteci.
     */
    private static final String PROPERTY_DB_USER = "db.user";
    /**
     * Ključ za lozinku korisnika baze podataka u konfiguracijskoj datoteci.
     */
    private static final String PROPERTY_DB_PASSWORD = "db.password";
    /**
     * Ključ za URL baze podataka u konfiguracijskoj datoteci.
     */
    private static final String PROPERTY_DB_URL = "db.url";

    /**
     * Sprema podatke o korisničkom računu u bazu podataka.
     *
     * @param firstName Ime korisnika
     * @param lastName Prezime korisnika
     * @param username Korisničko ime
     * @param password Lozinka
     */

    public void save(String firstName, String lastName, String username, String password) {

        try (Connection connection = getConnection()) {
            String query = "INSERT INTO useraccount (firstname, lastname, username, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provjerava valjanost korisničkog prijavljivanja.
     *
     * @param username Korisničko ime
     * @param password Lozinka
     * @return {@code true} ako je prijava valjana, inače {@code false}
     */
    public boolean validateLogin(String username, String password) {

        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM useraccount WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Provjerava postojanje korisnika s određenim korisničkim imenom.
     *
     * @param username Korisničko ime
     * @return {@code true} ako postoji korisnik s navedenim korisničkim imenom, inače {@code false}
     */
    public boolean findByUsername(String username) {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM useraccount WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Uspostavlja vezu s bazom podataka.
     *
     * @return Veza s bazom podataka
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            properties.load(fis);

            String databaseName = properties.getProperty(PROPERTY_DB_NAME);
            String databaseUser = properties.getProperty(PROPERTY_DB_USER);
            String databasePassword = properties.getProperty(PROPERTY_DB_PASSWORD);
            String url = properties.getProperty(PROPERTY_DB_URL);

            connection = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}