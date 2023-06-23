
package repository;

import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Klasa koja pruža funkcionalnosti za provjeru prijave korisnika u bazu podataka.
 */
public class LoginDBRepository {
    /**
     * Metoda za uspostavljanje veze s bazom podataka.
     *
     * @return Veza s bazom podataka
     */
    private Connection getConnection() {
        Connection databaseLink = null;

        try {
            Properties properties = new Properties();
            //FileInputStream fis = new FileInputStream("config.properties");
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
     * Metoda za provjeru ispravnosti prijave korisnika.
     *
     * @param username Korisničko ime
     * @param password Lozinka
     * @return true ako je prijava ispravna, false inače
     */
    public boolean validateLogin(String username, String password) {
        Connection connectDB = getConnection();
        boolean isValidLogin = false;

        String verifyLogin = "SELECT count(1) FROM useraccount WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = connectDB.prepareStatement(verifyLogin);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet queryResult = statement.executeQuery();

            if (queryResult.next()) {
                int count = queryResult.getInt(1);
                isValidLogin = count == 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (connectDB != null) {
                    connectDB.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isValidLogin;
    }
}