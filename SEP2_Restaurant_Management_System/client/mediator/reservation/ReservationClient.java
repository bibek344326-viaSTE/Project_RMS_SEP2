package client.mediator.reservation;

import client.model.Reservation.ReservationList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;

public interface ReservationClient {
    void reserveTable(ReservationList reservationList, Table table, Customer customer);
    void clearReservation(ReservationList reservationList, Table table, Customer customer);
}
