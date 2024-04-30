package client.core;

import client.model.Reservation.ReservationModel;
import client.model.Reservation.ReservationModelManager;
import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.table.TableModel;
import client.model.table.TableModelManager;

import java.rmi.RemoteException;

public class ModelFactory {

    private final ClientFactory client;
    private LoginModel  loginModel;
    private TableModel tablemodel;
    private ReservationModel reservationmodel;

    public ModelFactory (ClientFactory client) {
        this.client = client;
    }

    public LoginModel getLoginModel(){
       if (loginModel == null){
           try {
               loginModel = new LoginModelManager(client.getLoginClient());
           } catch (RemoteException e) {
               throw new RuntimeException(e);
           }
       }
       return loginModel;
    }

    public TableModel getTableModel() {
        if (tablemodel == null){
            try {
                tablemodel = new TableModelManager(client.getTableClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return tablemodel;
    }
    public ReservationModel getReservationModel() {
        if (reservationmodel == null){
            try {
                reservationmodel = new ReservationModelManager(client.getTableClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return reservationmodel;
    }
}
