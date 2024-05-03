package client.view.customer;

import client.core.ModelFactory;
import client.model.Reservation.ReservationModel;
import sharedResources.utils.Customer.Customer;

public class CustomerViewModel {

    private final ReservationModel reservationModel;

    public CustomerViewModel(ModelFactory modelFactory) {
        this.reservationModel = modelFactory.getReservationModel();
        // bind textarea over here
    }

    public void loginAsCustomer(String tableView) {
        // change name of argument better option is to create User and send Request obj
        reservationModel.loginAsCustomer(tableView);
    }

    public void clearTableForCustomer(Customer selectedCustomer) {

    }




   /* public void clearTableForCustomer(Customer customer) {
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
    }*/
}