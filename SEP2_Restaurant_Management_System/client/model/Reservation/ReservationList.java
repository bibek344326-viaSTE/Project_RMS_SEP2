package client.model.Reservation;

import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ReservationList implements PropertyChangeListener {
    private ArrayList<Reservation> reservations;

    public ReservationList() {
        reservations = new ArrayList<>();
    }

    // Method to add a reservation
    public void addReservation(Reservation reservation) {reservations.add(reservation);}
    // Method to remove a reservation
    public void removeReservation(Reservation reservation) {reservations.remove(reservation);}
    // Method to find a reservation by table number
    public Reservation findReservationByTable(int tableNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getTable().getTableNumber() == tableNumber) {
                return reservation;
            }
        }
        return null;
    }
    // Method to get the number of reservations
    public int getNumberOfReservations() {return reservations.size();}
    // Method to get all reservations
    public ArrayList<Reservation> getAllReservations() {return reservations;}

    @Override
    public String toString() {
        return "ReservationList{" +
                "reservations=" + reservations +
                '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("reservationStatus")) {
            boolean newOccupied = (boolean) evt.getNewValue();
            int tableNumber = ((Table) evt.getSource()).getTableNumber();

            if (newOccupied) {
                System.out.println("Table " + tableNumber + " has been reserved.");
            } else {
                System.out.println("Reservation for Table " + tableNumber + " has been cleared.");
            }
        }
    }
}