package server.mediator.manageTables;

import client.model.Reservation.ReservationList;
import server.model.tables.TableHandler;
import sharedResources.networking.serverInterfaces.TableServer;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.Request;
import sharedResources.utils.table.Table;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TablesServerSide implements TableServer {
    private TableHandler tableHandler;

    public TablesServerSide(TableHandler tableHandler) throws RemoteException {
        this.tableHandler = tableHandler;
        UnicastRemoteObject.exportObject(this, 0);

    }

    @Override
    public ArrayList<Table> getTables() throws RemoteException {
        return tableHandler.getTables();
    }

    @Override
    public void updateTable(Table table, String newName, int size) throws RemoteException {
        tableHandler.updateTable(table, newName, size);
    }

    @Override
    public Request createTable(Table table) throws RemoteException {
        return null;
    }

    @Override
    public void deleteTable(Table table) throws RemoteException {
        tableHandler.deleteTable(table);
    }

    @Override
    public boolean reserveTables(int numberOfTables) throws RemoteException {
        for (int i = 0; i < numberOfTables; i++) {
            tableHandler.reserveTable();
        }
        return true;
    }

    @Override
    public boolean clearReservation(ReservationList reservationList, Table table, Customer customer) {
        return false;
    }

    @Override
    public boolean reserveTable(ReservationList reservationList, Table table, Customer customer) {
        return false;
    }
}
