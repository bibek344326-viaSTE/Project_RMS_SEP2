package client.mediator;

import sharedResources.networking.serverInterfaces.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClientRMI {
    public static Server getServerFromRMI() {
        Server server = null;
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            server = (Server) registry.lookup("Server");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return server;
    }

}