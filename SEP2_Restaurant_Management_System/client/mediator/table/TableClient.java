package client.mediator.table;

import client.model.Reservation.ReservationList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;

public interface TableClient {
    void reserveTables(int numberOfTables);
    void reserveTable(ReservationList reservationList, Table table, Customer customer);
    void clearReservation(ReservationList reservationList, Table table, Customer customer);
}
