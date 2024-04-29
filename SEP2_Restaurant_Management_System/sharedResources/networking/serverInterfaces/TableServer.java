package sharedResources.networking.serverInterfaces;

import sharedResources.utils.Request;
import sharedResources.utils.table.Table;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TableServer extends Remote {
    ArrayList<Table> getTables() throws RemoteException;

    void updateTable(Table table, String newName, int size) throws RemoteException;

    Request createTable(Table table) throws RemoteException;

    void deleteTable(Table table) throws RemoteException;

    boolean reserveTables(int numberOfTables) throws RemoteException;
}

