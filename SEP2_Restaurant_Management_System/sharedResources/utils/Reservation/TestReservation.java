package sharedResources.utils.Reservation;

import client.model.Reservation.ReservationList;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;

public class TestReservation {
    public static void main(String[] args) {
        // Create a reservation list
        ReservationList reservationList = new ReservationList();

        // Create some tables
        Table table1 = new Table(1, 4, isOccupied); // Table number 1 with capacity 4
        Table table2 = new Table(2, 6, isOccupied); // Table number 2 with capacity 6

        // Create reservations
        LocalDateTime reservationTime1 = LocalDateTime.now().plusHours(1); // 1 hour from now
        LocalDateTime reservationTime2 = LocalDateTime.now().plusHours(2); // 2 hours from now
        Reservation reservation1 = new Reservation(reservationTime1, table1);
        Reservation reservation2 = new Reservation(reservationTime2, table2);

        // Test reserveTable()
        reservation1.reserveTable(reservationList, table1);
        reservation2.reserveTable(reservationList, table2);

        // Check if reservations were added to the list
        System.out.println("All Reservations:");
        for (Reservation reservation : reservationList.getAllReservations()) {
            System.out.println("Reservation Time: " + reservation.getReservationTime() +
                    ", Table Number: " + reservation.getTable().getTableNumber());
        }

        // Test clearReservation()
        reservation1.clearReservation(reservationList, table1);

        // Check if reservation was removed from the list
        System.out.println("All Reservations after clearing Reservation 1:");
        for (Reservation reservation : reservationList.getAllReservations()) {
            System.out.println("Reservation Time: " + reservation.getReservationTime() +
                    ", Table Number: " + reservation.getTable().getTableNumber());
        }
    }
}