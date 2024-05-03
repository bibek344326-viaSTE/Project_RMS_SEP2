package server.mediator.login;

import server.model.create.CreateHandler;
import sharedResources.mediator.serverInterfaces.CreateAccountServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreateServerManager implements CreateAccountServer {
    private CreateHandler createHandler;

    public CreateServerManager(CreateHandler createHandler) throws RemoteException {
        this.createHandler = createHandler;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public String addUser(String username, String password, String userType) throws RemoteException {
        return createHandler.addUser(username, password, userType);
    }
}
