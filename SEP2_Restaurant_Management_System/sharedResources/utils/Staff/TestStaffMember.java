package sharedResources.utils.Staff;

import client.model.Reservation.ReservationList;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;

public class TestStaffMember {
    public static void main(String[] args) {
        // Create a reservation list
        ReservationList reservationList = new ReservationList();

        // Create a table
        Table table1 = new Table(1, 4, isOccupied); // Table number 1 with capacity 4

        // Create a staff member
        StaffMember staffMember = new StaffMember("John");

        // Make a reservation
        LocalDateTime reservationTime = LocalDateTime.now().plusHours(1); // 1 hour from now
        staffMember.makeReservation(reservationList, table1, reservationTime);

        // Check if reservation was added to the list
        System.out.println("All Reservations:");
        for (Reservation reservation : reservationList.getAllReservations()) {
            System.out.println("Reservation Time: " + reservation.getReservationTime() +
                    ", Table Number: " + reservation.getTable().getTableNumber());
        }

        // Clear the reservation
        staffMember.clearReservation(reservationList, table1);
    }
}