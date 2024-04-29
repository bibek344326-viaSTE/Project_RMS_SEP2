package client.view.customer;

import client.model.Reservation.ReservationModel;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.Reservation.Reservation;


public class CustomerViewModel {
    private ReservationModel reservationModel;

    public void init(ReservationModel reservationModel) {
        this.reservationModel =reservationModel;
    }

    public void clearTableForCustomer(Customer customer) {
        // Find the reservation for the given customer
        Reservation reservation = findReservationByCustomer(customer);
        if (reservation != null) {
            // Remove the reservation
            reservationModel.removeReservation(reservation);
            // Mark the table as available
            reservation.getTable().vacateTable();
            System.out.println("Table cleared for customer: " + customer.getName());
        } else {
            System.out.println("No reservation found for the selected customer.");
        }
    }

    private Reservation findReservationByCustomer(Customer customer) {
        // Loop through all reservations to find the one associated with the customer
        for (Reservation reservation : reservationModel.getAllReservations()) {
            if (reservation.getCustomer().equals(customer)) {
                return reservation;
            }
        }
        return null; // Return null if no reservation is found
    }
}