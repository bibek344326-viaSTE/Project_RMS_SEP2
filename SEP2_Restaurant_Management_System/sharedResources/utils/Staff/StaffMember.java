package sharedResources.utils.Staff;

import client.model.Reservation.ReservationList;
import client.model.table.TableList;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class StaffMember {
    private String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeReservation(ReservationList reservationList, Table table, LocalDateTime reservationTime) {
        Reservation reservation = new Reservation(reservationTime, table);
        reservation.reserveTable(reservationList, table);
    }

    public void clearReservation(ReservationList reservationList, Table table) {
        Reservation reservation = reservationList.findReservationByTable(table.getTableNumber());
        if (reservation != null) {
            reservation.clearReservation(reservationList, table);
        } else {
            System.out.println("No reservation found for the specified table.");
        }
    }
}