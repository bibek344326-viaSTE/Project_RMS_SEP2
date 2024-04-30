package client.model.Reservation;

import sharedResources.utils.Reservation.Reservation;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface ReservationModel {
    void addReservation(Reservation reservation);

    void removeReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation findReservationByTable(int tableNumber);

    int getNumberOfReservations();

    void addListener(PropertyChangeListener listener);

    void removeListener(PropertyChangeListener listener);
}
