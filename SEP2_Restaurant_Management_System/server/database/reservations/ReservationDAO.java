package server.database.reservations;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface ReservationDAO {
    void addReservation(int tableNumber, int customerId, LocalDateTime reservationTime) throws SQLException;

    void clearTableOccupancy(int tableNumber) throws SQLException;
}
