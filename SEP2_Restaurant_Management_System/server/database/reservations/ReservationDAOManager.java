package server.database.reservations;

import server.database.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;

public class ReservationDAOManager implements ReservationDAO {
    @Override
    public void addReservation(int tableNumber, int customerId, LocalDateTime reservationTime) throws SQLException {
        Connection connection = null; // Define the connection variable outside try block
        try {
            connection = DatabaseConnection.getConnection();
            // Start transaction
            connection.setAutoCommit(false);

            // Insert reservation
            PreparedStatement reservationStatement = connection.prepareStatement(
                    "INSERT INTO reservation (table_number, customer_id, reservation_time) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            reservationStatement.setInt(1, tableNumber);
            reservationStatement.setInt(2, customerId);
            reservationStatement.setTimestamp(3, Timestamp.valueOf(reservationTime));
            reservationStatement.executeUpdate();

            // Get the generated reservation_id
            ResultSet generatedKeys = reservationStatement.getGeneratedKeys();
            int reservationId = 0;
            if (generatedKeys.next()) {
                reservationId = generatedKeys.getInt(1);
            }

            // Update table status
            PreparedStatement tableUpdateStatement = connection.prepareStatement(
                    "UPDATE tables SET isOccupied = true WHERE table_number = ?");
            tableUpdateStatement.setInt(1, tableNumber);
            tableUpdateStatement.executeUpdate();

            // Commit transaction
            connection.commit();

            System.out.println("Reservation added successfully with ID: " + reservationId);
        } catch (SQLException e) {
            // Rollback transaction if an error occurs
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            // Close connection in finally block to ensure it's always closed
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void clearTableOccupancy(int tableNumber) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE tables SET isOccupied = false WHERE table_number = ?");
            preparedStatement.setInt(1, tableNumber);
            preparedStatement.executeUpdate();

            System.out.println("Table " + tableNumber + " occupancy cleared successfully.");
        }
    }
}
