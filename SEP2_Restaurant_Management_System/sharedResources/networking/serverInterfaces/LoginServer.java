package sharedResources.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer  extends Remote {
    String isLoginPossible(String username, String password) throws RemoteException;

    String signUp(String userName, String password) throws RemoteException;
}
