
package repository;
import controller.CartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/*
public class PriceDBRepository {
    private ObservableList<CartController.Data> dataListCart;

    public PriceDBRepository() {
        dataListCart = FXCollections.observableArrayList();
    }

    public void addData(CartController.Data data) {
        insertDataIntoDatabase(data);
        dataListCart.add(data);

    }

    public void removeData(CartController.Data data) {
        dataListCart.remove(data);
        deleteDataFromDatabase(data);
    }

    public ObservableList<CartController.Data> getDataList() {
        return dataListCart;
    }

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
    }*/
/*
    private void insertDataIntoDatabase(CartController.Data data) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO cart (id, movie, dateandtime, numberoftickets, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, data.getId());
            statement.setString(2, data.getMovie());
            statement.setString(3, data.getDateAndTime());
            statement.setInt(4, data.getNumberOfTickets());
            statement.setInt(5, data.getPrice());

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
*//*
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
*/



import controller.CartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PriceDBRepository {
    private ObservableList<CartController.Data> dataListCart;

    public PriceDBRepository() {
        dataListCart = FXCollections.observableArrayList();
    }

    public void addData(CartController.Data data) {
        insertDataIntoDatabase(data);
        dataListCart.add(data);
    }

    public void removeData(CartController.Data data) {
        deleteDataFromDatabase(data);
        dataListCart.remove(data);
    }

    public ObservableList<CartController.Data> getDataList() {
        return dataListCart;
    }

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

