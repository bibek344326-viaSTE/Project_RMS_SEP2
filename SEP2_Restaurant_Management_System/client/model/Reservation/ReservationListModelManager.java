package client.model.Reservation;

import client.mediator.reservation.ReservationClient;
import sharedResources.utils.Reservation.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ReservationListModelManager implements ReservationModel {
    private final ReservationList reservationList;
    private final PropertyChangeSupport property;
    private ReservationListModelManager reservationListModelManager;

    public ReservationListModelManager(ReservationClient reservationClient) {
        property = new PropertyChangeSupport(this);
        reservationList = new ReservationList();
        createDummyData();
    }

    private void createDummyData() {
        // Create dummy reservations
        // Example:
        // Reservation reservation1 = new Reservation(LocalDateTime.of(2024, 4, 24, 10, 0), someTable);
        // reservationList.addReservation(reservation1);
        // You can add more dummy data as needed
    }

    @Override
    public void addReservation(Reservation reservation) {
        reservationList.addReservation(reservation);
        property.firePropertyChange("ReservationAdded", null, reservation);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservationList.removeReservation(reservation);
        property.firePropertyChange("ReservationRemoved", reservation, null);
    }

    @Override
    public int getNumberOfReservations() {
        return reservationList.getNumberOfReservations();
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        return reservationList.getAllReservations();
    }

    @Override
    public Reservation findReservationByTable(int tableNumber) {
        return reservationList.findReservationByTable(tableNumber);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public void loginAsCustomer(String hi) {
        reservationListModelManager.loginAsCustomer(hi);
    }
}