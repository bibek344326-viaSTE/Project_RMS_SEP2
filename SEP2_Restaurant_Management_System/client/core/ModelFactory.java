package client.core;

import client.model.login.LoginModel;
import client.model.login.LoginModelManager;
import client.model.table.TableManagement;

import java.rmi.RemoteException;

public class ModelFactory {

    private final ClientFactory client;
    private LoginModel  loginModel;

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

}
