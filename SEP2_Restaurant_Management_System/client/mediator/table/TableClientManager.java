package client.mediator.table;

import client.mediator.RemoteClientRMI;
import sharedResources.mediator.serverInterfaces.TableServer;

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

    }



