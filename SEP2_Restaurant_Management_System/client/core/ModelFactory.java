package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.table.TableModel;
import client.model.table.TableModelManager;

import java.rmi.RemoteException;

public class ModelFactory {

    private final ClientFactory client;
    private LoginModel  loginModel;
    private TableModel tableManagementModel;

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
        if (tableManagementModel == null){
            try {
                tableManagementModel = new TableModelManager(client.getTableClient());
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        return tableManagementModel;
    }
}
