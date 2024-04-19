package sharedResources.utils.Reservation;



import client.model.Reservation.ReservationList;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime reservationTime;
    private Table table; // Added table member variable

    public Reservation(LocalDateTime reservationTime, Table table) {
        this.reservationTime = reservationTime;
        this.table = table; // Initialize the table
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Table getTable() {
        return table;
    }

    public void reserveTable(ReservationList reservationList, Table table) {
        // Check if the reservation time is in the future
        if (reservationTime.isAfter(LocalDateTime.now())) {
            // Add reservation only if the time is in the future
            reservationList.addReservation(this);
            // Mark the table as reserved
            table.occupyTable();
        } else {
            System.out.println("Cannot reserve a table for past time.");
        }
    }

    public void clearReservation(ReservationList reservationList, Table table) {
        // Find the reservation for the given table number
        Reservation reservationToRemove = reservationList.findReservationByTable(table.getTableNumber());
        if (reservationToRemove != null) {
            // Remove reservation from the list
            reservationList.removeReservation(reservationToRemove);
            // Mark the table as available
            table.vacateTable();
        } else {
            System.out.println("No reservation found for the specified table.");
        }
    }
}