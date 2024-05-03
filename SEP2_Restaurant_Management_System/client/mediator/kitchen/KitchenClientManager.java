package client.mediator.kitchen;

import client.mediator.RemoteClientRMI;
import sharedResources.mediator.serverInterfaces.LoginServer;

import java.rmi.RemoteException;

public class KitchenClientManager implements KitchenClient{
    private LoginServer server;

    public KitchenClientManager() throws RemoteException {
        this.server = RemoteClientRMI.getServerFromRMI().getLoginServer();
    }


    @Override
    public void loginToKitchenView(String hi) {
        try {
            String loginOK = server.isLoginPossible(hi, "abc");
            System.out.println(loginOK);
        } catch (RemoteException e) {
            System.out.println("error in " +
                    "KitchenClientManager"
            );
            throw new RuntimeException(e);
        }
    }
}
