package sharedResources.mediator.serverInterfaces;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;

    void startServer() throws RemoteException, AlreadyBoundException;

    TableServer getTableServer() throws RemoteException;

    FoodMenuServer getFoodMenuServer() throws RemoteException;
}
