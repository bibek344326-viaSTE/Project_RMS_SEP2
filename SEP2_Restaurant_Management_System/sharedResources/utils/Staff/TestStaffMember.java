package sharedResources.utils.Staff;

import client.model.Reservation.ReservationList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;

public class TestStaffMember {
    public static void main(String[] args) {
        // Create a reservation list
        ReservationList reservationList = new ReservationList();

        // Create a table
        Table table1 = new Table(1, 4); // Table number 1 with capacity 4

        // Create a customer
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setPhonenumber("1234567890");

        // Create a staff member
        StaffMember staffMember = new StaffMember("John");

        // Make a reservation
        LocalDateTime reservationTime = LocalDateTime.now().plusHours(1); // 1 hour from now
        staffMember.makeReservation(reservationList, table1, reservationTime, customer);

        // Check if reservation was added to the list
        System.out.println("All Reservations:");
        for (Reservation reservation : reservationList.getAllReservations()) {
            System.out.println("Reservation Time: " + reservation.getReservationTime() +
                    ", Table Number: " + reservation.getTable().getTableNumber() +
                    ", Customer: " + reservation.getCustomer().getName());
        }

        // Clear the reservation
        staffMember.clearReservation(reservationList, table1, customer);
    }
}