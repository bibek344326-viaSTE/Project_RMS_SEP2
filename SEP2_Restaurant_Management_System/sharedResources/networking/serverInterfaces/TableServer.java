package sharedResources.networking.serverInterfaces;

import sharedResources.utils.table.Table;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TableServer extends Remote {
    ArrayList<Table> getTables() throws RemoteException;
    void updateTable(Table table) throws RemoteException;

}

