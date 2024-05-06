package client.core;

import client.model.Reservation.ReservationModel;
import client.model.Reservation.ReservationModelManager;
import client.model.foodmenu.FoodmenuManager;
import client.model.foodmenu.FoodmenuModel;
import client.model.kitchen.KitchenModel;
import client.model.kitchen.KitchenModelManager;
import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.staff.StaffModel;
import client.model.staff.StaffModelManager;
import client.model.table.TableModel;
import client.model.table.TableModelManager;

import java.rmi.RemoteException;

public class ModelFactory {

    private final ClientFactory client;
    private LoginModel loginModel;
    private TableModel tableManagementModel;
    private ReservationModel reservationModel;
    private StaffModel staffModel;
    private KitchenModel kitchenModel;
    private FoodmenuModel foodmenuModel;

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
                tableManagementModel = new TableModelManager(client.getTableClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return tableManagementModel;
    }

    public ReservationModel getReservationModel() {
        if (reservationModel == null) {
            try {
                reservationModel = new ReservationModelManager(client.getReservationClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return reservationModel;
    }

    public StaffModel getStaffModel() {
        if (staffModel == null) {
            try {
                staffModel = new StaffModelManager(client.getStaffClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return staffModel;

    }

    public KitchenModel getKitchenModel() {
        if (kitchenModel == null) {
            try {
                kitchenModel = new KitchenModelManager(client.getKitchenClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return kitchenModel;
    }
    public FoodmenuModel getFoodMenuModel() {
        if (foodmenuModel == null) {
            try {
                foodmenuModel = new FoodmenuManager(client.getFoodMenuClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return foodmenuModel;
    }
}
