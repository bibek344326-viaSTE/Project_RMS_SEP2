package client.core;

import client.mediator.Client;
import client.mediator.ClientHandler;
import client.mediator.login.LoginClient;
import client.mediator.login.LoginClientManager;
import client.mediator.reservation.ReservationClient;
import client.mediator.reservation.ReservationClientManager;
import client.mediator.table.TableClient;
import client.mediator.table.TableClientManager;

import java.rmi.RemoteException;

public class ClientFactory {

    private LoginClient loginClient;
    private TableClient tableClient;
    private ReservationClient reservationClient;

    public LoginClient getLoginClient() throws RemoteException {
        if(loginClient == null){
            loginClient = new LoginClientManager();
        }
        return loginClient;
    }

    public TableClient getTableClient() throws RemoteException {
        if(tableClient == null){
            tableClient = new TableClientManager();
        }
        return tableClient;
    }

   /* public ReservationClient getReservationClient() {
        if(reservationClient == null){
            reservationClient= new ReservationClientManager();
        }
        return reservationClient;
    }*/
}