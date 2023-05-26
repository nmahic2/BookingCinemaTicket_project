/*package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDBRepository {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName ="cinemaproject";
        String databaseUser ="";
        String databasePassword ="";
        String url="jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }

        return databaseLink;
    }

}
*/
package repository;

import java.sql.*;

public class LoginDBRepository {
    public Connection getConnection() {
        Connection databaseLink = null;
        String databaseName = "cinemaproject";
        String databaseUser = "root";
        String databasePassword = "12345";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

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
            // Zatvorite PreparedStatement i Connection
            // Možete koristiti try-with-resources blok za automatsko zatvaranje resursa u novijim verzijama Jave
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