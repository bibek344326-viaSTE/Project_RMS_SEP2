package client.core;

import client.mediator.Client;
import client.mediator.ClientHandler;
import client.mediator.kitchen.KitchenClient;
import client.mediator.kitchen.KitchenClientManager;
import client.mediator.login.LoginClient;
import client.mediator.login.LoginClientManager;
import client.mediator.reservation.ReservationClient;
import client.mediator.reservation.ReservationClientManager;
import client.mediator.staff.StaffClient;
import client.mediator.staff.StaffClientManager;
import client.mediator.table.TableClient;
import client.mediator.table.TableClientManager;

import java.rmi.RemoteException;

public class ClientFactory {

    private LoginClient loginClient;
    private TableClient tableClient;
    private ReservationClient reservationClient;
    private StaffClient staffClient;
    private KitchenClient kitchenClient;

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
    public ReservationClient getReservationClient() throws RemoteException {
        if(reservationClient == null){
            reservationClient= new ReservationClientManager();
        }
        return reservationClient;
    }

    public StaffClient getStaffClient() throws RemoteException {
        if(staffClient == null){
            staffClient= new StaffClientManager();
        }
        return staffClient;

    }

    public KitchenClient getKitchenClient() throws RemoteException {
        if(kitchenClient == null){
            kitchenClient= new KitchenClientManager();
        }
        return kitchenClient;
    }
}

