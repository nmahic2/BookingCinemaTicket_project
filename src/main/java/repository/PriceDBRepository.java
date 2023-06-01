package repository;


import controller.CartController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;

public class PriceDBRepository {
    private ObservableList<CartController.Data> dataListCashRegister;

    public PriceDBRepository() {
        dataListCashRegister = FXCollections.observableArrayList();
    }

    public void addData(CartController.Data data) {
        dataListCashRegister.add(data);
       insertDataIntoDatabase(data);
    }

    public void removeData(CartController.Data data) {
        dataListCashRegister.remove(data);
    }

    public ObservableList<CartController.Data> getDataList() {
        return dataListCashRegister;
    }

    private static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cinemaproject?useSSL=false";
        String username = "root";
        String password = "12345";
        return DriverManager.getConnection(url, username, password);
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



}