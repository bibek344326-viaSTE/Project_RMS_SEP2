package client.model.Reservation;

import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.util.ArrayList;
import java.util.List;

public class ReservationList {
    private ArrayList<Reservation> reservations;

    public ReservationList() {
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public ArrayList<Reservation> getAllReservations() {
        return reservations;
    }

    public Reservation findReservation(Reservation targetReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.equals(targetReservation)) {
                return reservation;
            }
        }
        return null;
    }
    public Reservation findReservationByTable(int tableNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getTable().getTableNumber() == tableNumber) {
                return reservation;
            }
        }
        return null;
    }
}