package repository;


import controller.CartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PriceDBRepository {
    private ObservableList<CartController.Data> dataListCart;

    public PriceDBRepository() {
        dataListCart = FXCollections.observableArrayList();
    }

    public void addData(CartController.Data data) {
        dataListCart.add(data);
       insertDataIntoDatabase(data);
    }

    public void removeData(CartController.Data data) {
        dataListCart.remove(data);
    }

    public ObservableList<CartController.Data> getDataList() {
        return dataListCart;
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cinemaproject?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
    }

    private void insertDataIntoDatabase(CartController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO cart (movie, dateAndTime, numberOfTickets, price) VALUES (?, ?, ?, ?)";
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


    //dohvaca filmove iz baze u listu
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


}


