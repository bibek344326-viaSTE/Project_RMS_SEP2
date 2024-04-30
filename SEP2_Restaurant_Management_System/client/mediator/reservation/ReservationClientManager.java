package client.mediator.reservation;

import client.mediator.RemoteClientRMI;
import client.model.Reservation.ReservationList;
import sharedResources.networking.serverInterfaces.LoginServer;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;

import java.rmi.RemoteException;

public class ReservationClientManager implements ReservationClient{

    private LoginServer server;

    public ReservationClientManager() throws RemoteException {
        this.server = RemoteClientRMI.getServerFromRMI().getLoginServer();
    }


    @Override
    public void reserveTable(ReservationList reservationList, Table table, Customer customer) {

    }

    @Override
    public void clearReservation(ReservationList reservationList, Table table, Customer customer) {

    }
}
