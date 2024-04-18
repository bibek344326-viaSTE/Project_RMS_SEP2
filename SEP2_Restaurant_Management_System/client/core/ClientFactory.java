package client.core;

import client.mediator.Client;
import client.mediator.ClientHandler;
import client.mediator.login.LoginClient;
import client.mediator.login.LoginClientManager;

import java.rmi.RemoteException;

public class ClientFactory {

    private LoginClient loginClient;

    public LoginClient getLoginClient() throws RemoteException {
        if(loginClient == null){
            loginClient = new LoginClientManager();
        }
        return loginClient;
    }
}
