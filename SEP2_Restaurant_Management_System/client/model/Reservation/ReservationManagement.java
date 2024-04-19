package client.model.Reservation;

import sharedResources.utils.Reservation.Reservation;

import java.util.List;

public interface ReservationManagement {
    void addReservation(Reservation reservation);
    void removeReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation findReservation(Reservation targetReservation);
    Reservation findReservationByTable(int tableNumber);
}

