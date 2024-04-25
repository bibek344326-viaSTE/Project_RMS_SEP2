package sharedResources.utils.Reservation;



import client.model.Reservation.ReservationList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

public class Reservation implements UnnamedPropertyChangeSubject {
    private LocalDateTime reservationTime;
    private Table table;
    private Customer customer; // Added customer member variable
    private PropertyChangeSupport property;

    public Reservation(LocalDateTime reservationTime, Table table, Customer customer) {
        this.reservationTime = reservationTime;
        this.table = table;
        this.customer = customer; // Initialize the customer
        this.property = new PropertyChangeSupport(this);
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Table getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void reserveTable(ReservationList reservationList, Table table, Customer customer) {
        // Check if the reservation time is in the future
        if (reservationTime.isAfter(LocalDateTime.now())) {
            // Check if the provided customer matches the reservation's customer
            if (this.customer.getName().equals(customer.getName()) && this.customer.getPhonenumber().equals(customer.getPhonenumber())) {
                // Add reservation only if the time is in the future and customer details match
                reservationList.addReservation(this);
                // Mark the table as reserved
                boolean oldOccupied = table.isOccupied();
                table.occupyTable();
                property.firePropertyChange("reservationStatus", oldOccupied, table.isOccupied());
            } else {
                System.out.println("Customer details do not match the reservation.");
            }
        } else {
            System.out.println("Cannot reserve a table for past time.");
        }
    }

    public void clearReservation(ReservationList reservationList, Table table, Customer customer) {
        // Check if the provided customer matches the reservation's customer
        if (this.customer.getName().equals(customer.getName()) && this.customer.getPhonenumber().equals(customer.getPhonenumber())) {
            // Find the reservation for the given table number
            Reservation reservationToRemove = reservationList.findReservationByTable(table.getTableNumber());
            if (reservationToRemove != null) {
                // Remove reservation from the list
                reservationList.removeReservation(reservationToRemove);
                // Mark the table as available
                boolean oldOccupied = table.isOccupied();
                table.vacateTable();
                property.firePropertyChange("reservationStatus", oldOccupied, table.isOccupied());
            } else {
                System.out.println("No reservation found for the specified table.");
            }
        } else {
            System.out.println("Customer details do not match the reservation.");
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationTime=" + reservationTime +
                ", table=" + table +
                ", customer=" + customer +
                '}';
    }

    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}