package client.core;

import client.model.Reservation.ReservationListModelManager;
import client.model.Reservation.ReservationModel;
import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.table.TableListModelManager;
import client.model.table.TableModel;

import java.rmi.RemoteException;

public class ModelFactory {

    private final ClientFactory client;
    private LoginModel loginModel;
    private TableModel tableManagementModel;
    private ReservationModel reservationModel;

    public ModelFactory(ClientFactory client) {
        this.client = client;
    }

    public LoginModel getLoginModel() {
        if (loginModel == null) {
            try {
                loginModel = new LoginModelManager(client.getLoginClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return loginModel;
    }

    public TableModel getTableModel() {
        if (tableManagementModel == null) {
            try {
                tableManagementModel = new TableListModelManager(client.getTableClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return tableManagementModel;
    }
}
    /*public ReservationModel getReservationModel() {
        if (reservationModel == null){
            try {
                reservationModel = new ReservationListModelManager(client.getReservationClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return reservationModel;
    }

}*/