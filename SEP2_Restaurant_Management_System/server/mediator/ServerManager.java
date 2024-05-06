package server.mediator;

import sharedResources.mediator.serverInterfaces.FoodMenuServer;
import sharedResources.mediator.serverInterfaces.LoginServer;
import sharedResources.mediator.serverInterfaces.Server;
import sharedResources.mediator.serverInterfaces.TableServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerManager  implements Server {

    private final LoginServer loginserver;


    public ServerManager(LoginServer loginServer) throws RemoteException {
        this.loginserver = loginServer;
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public LoginServer getLoginServer() throws RemoteException {
        return loginserver;
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server started...");
    }

    @Override
    public TableServer getTableServer() throws RemoteException {
        return null;
    }

    @Override
    public FoodMenuServer getFoodMenuServer() throws RemoteException {
        return null;
    }
}
