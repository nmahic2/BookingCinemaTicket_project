
package repository;
import controller.CartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Klasa koja pruža funkcionalnosti za pristup cijenama filmova u bazi podataka.
 */
public class PriceDBRepository {
    private ObservableList<CartController.Data> dataListCart;
    /**
     * Konstruktor koji inicijalizira listu podataka o košarici.
     */
    public PriceDBRepository() {
        dataListCart = FXCollections.observableArrayList();
    }
    /**
     * Dodaje podatke o košarici u bazu podataka i listu podataka.
     *
     * @param data Podaci o košarici
     */
    public void addData(CartController.Data data) {
        insertDataIntoDatabase(data);
        dataListCart.add(data);
    }
    /**
     * Uklanja podatke o košarici iz baze podataka i liste podataka.
     *
     * @param data Podaci o košarici
     */
    public void removeData(CartController.Data data) {
        deleteDataFromDatabase(data);
        dataListCart.remove(data);
    }
    /**
     * Vraća listu podataka o košarici.
     *
     * @return Lista podataka o košarici
     */
    public ObservableList<CartController.Data> getDataList() {
        return dataListCart;
    }
    /**
     * Metoda za uspostavljanje veze s bazom podataka.
     *
     * @return Veza s bazom podataka
     */
    private Connection getConnection() {
        Connection databaseLink = null;

        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");

            properties.load(fis);

            String databaseName = properties.getProperty("db.name");
            String databaseUser = properties.getProperty("db.user");
            String databasePassword = properties.getProperty("db.password");
            String url = properties.getProperty("db.url");

            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }
    /**
     * Ubacuje podatke o košarici u bazu podataka.
     *
     * @param data Podaci o košarici
     */
    private void insertDataIntoDatabase(CartController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO cart (movie, dateandtime, numberoftickets, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, data.getMovie());
            statement.setString(2, data.getDateAndTime());
            statement.setInt(3, data.getNumberOfTickets());
            statement.setInt(4, data.getPrice());

            statement.executeUpdate();

            // Retrieve the generated ID
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                data.setId(generatedId);
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Briše podatke o košarici iz baze podataka.
     *
     * @param data Podaci o košarici koju treba obrisati
     */
    private void deleteDataFromDatabase(CartController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM cart WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, data.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Vraća cijenu za određeni film iz baze podataka.
     *
     * @param movie Naziv filma
     * @return Cijena filma
     */
    public int getPriceForMovie(String movie) {
        try (Connection connection = getConnection()) {
            String query = "SELECT price FROM movies WHERE movie = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, movie);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // Return a default price if the movie is not found or there is an error
    }
    /**
     * Vraća listu svih filmova iz baze podataka.
     *
     * @return Lista svih filmova
     */
    public List<String> getAllMovies() {
        List<String> movies = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String query = "SELECT movie FROM movies";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String movie = resultSet.getString("movie");
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}

