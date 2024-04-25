package sharedResources.utils.Staff;

import client.model.Reservation.ReservationList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;

public class StaffMember {
    private String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeReservation(ReservationList reservationList, Table table, LocalDateTime reservationTime, Customer customer) {
        Reservation reservation = new Reservation(reservationTime, table, customer);
        reservation.reserveTable(reservationList, table, customer);
    }

    public void clearReservation(ReservationList reservationList, Table table, Customer customer) {
        Reservation reservation = reservationList.findReservationByTable(table.getTableNumber());
        if (reservation != null) {
            reservation.clearReservation(reservationList, table, customer);
        } else {
            System.out.println("No reservation found for the specified table.");
        }
    }
}