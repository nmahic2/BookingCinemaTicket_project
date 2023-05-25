package repository;

import java.sql.*;

public class JdbcTicketPriceRepository implements TicketPriceRepository {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";

    @Override
    public double getTicketPrice(String movieName) {
        double ticketPrice = 0.0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT price FROM movies WHERE name = ?")) {

            stmt.setString(1, movieName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ticketPrice = rs.getDouble("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ticketPrice;
    }
}
