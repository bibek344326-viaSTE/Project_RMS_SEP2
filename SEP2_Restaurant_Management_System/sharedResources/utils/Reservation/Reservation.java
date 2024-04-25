package sharedResources.utils.Reservation;



import client.model.Reservation.ReservationList;
import sharedResources.utils.table.Table;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;

public class Reservation implements UnnamedPropertyChangeSubject {
    private LocalDateTime reservationTime;
    private Table table; // Added table member variable
    private PropertyChangeSupport property;

    public Reservation(LocalDateTime reservationTime, Table table) {
        this.reservationTime = reservationTime;
        this.table = table; // Initialize the table
        this.property = new PropertyChangeSupport(this);
    }

    public LocalDateTime getReservationTime() {return reservationTime;}
    public Table getTable() {return table;}

    public void reserveTable(ReservationList reservationList, Table table) {
        // Check if the reservation time is in the future
        if (reservationTime.isAfter(LocalDateTime.now())) {
            // Add reservation only if the time is in the future
            reservationList.addReservation(this);
            // Mark the table as reserved
            boolean oldOccupied = table.isOccupied();
            table.occupyTable();
            property.firePropertyChange("reservationStatus", oldOccupied, table.isOccupied());
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
            boolean oldOccupied = table.isOccupied();
            table.vacateTable();
            property.firePropertyChange("reservationStatus", oldOccupied, table.isOccupied());
        } else {
            System.out.println("No reservation found for the specified table.");
        }
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationTime=" + reservationTime +
                ", table=" + table +
                '}';
    }
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}