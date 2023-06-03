/*package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.UserAccountService;

public class UserAccountRepository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cinemaproject";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";

    public void save(String firstName, String lastName, String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
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

    public boolean validateLogin(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
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

    public boolean findByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
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
}
*/
package repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import service.UserAccountService;

public class UserAccountRepository {
    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static final String PROPERTY_DB_NAME = "db.name";
    private static final String PROPERTY_DB_USER = "db.user";
    private static final String PROPERTY_DB_PASSWORD = "db.password";
    private static final String PROPERTY_DB_URL = "db.url";

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
