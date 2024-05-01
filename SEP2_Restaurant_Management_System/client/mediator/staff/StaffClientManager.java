package client.mediator.staff;

import client.mediator.RemoteClientRMI;
import sharedResources.networking.serverInterfaces.LoginServer;

import java.rmi.RemoteException;

public class StaffClientManager implements StaffClient{

    private LoginServer server;

    public StaffClientManager() throws RemoteException {
        this.server = RemoteClientRMI.getServerFromRMI().getLoginServer();
    }

    @Override
    public void loginToStaffMemberView(String hi) {

    }
}
