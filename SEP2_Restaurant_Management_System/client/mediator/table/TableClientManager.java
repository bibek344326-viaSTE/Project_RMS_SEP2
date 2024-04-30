package client.mediator.table;

import client.mediator.RemoteClientRMI;
import client.model.Reservation.ReservationList;
import sharedResources.networking.serverInterfaces.TableServer;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;

import java.rmi.RemoteException;

public class TableClientManager implements TableClient{
    private final TableServer server;

    public TableClientManager() throws RemoteException {
        this.server = RemoteClientRMI.getServerFromRMI().getTableServer();
    }


    @Override
    public void reserveTables(int numberOfTables) {
        try {
            boolean reservationSuccess = server.reserveTables(numberOfTables);
            if (reservationSuccess) {
                System.out.println(numberOfTables + " table(s) reserved successfully.");
            } else {
                System.out.println("Failed to reserve tables.");
            }
        } catch (RemoteException e) {
            System.out.println("Error in TableClientManager");
            throw new RuntimeException(e);
        }
    }
    @Override
    public void reserveTable(ReservationList reservationList, Table table, Customer customer) {
        boolean reservationSuccess = server.reserveTable(reservationList, table, customer);
        if (reservationSuccess) {
            System.out.println("Table reserved successfully.");
        } else {
            System.out.println("Failed to reserve the table.");
        }
    }
    @Override
    public void clearReservation(ReservationList reservationList, Table table, Customer customer) {
        boolean reservationSuccess = server.clearReservation(reservationList, table, customer);
        if (reservationSuccess) {
            System.out.println("Reservation cleared successfully.");
        } else {
            System.out.println("Failed to clear the reservation.");
        }
    }
}


