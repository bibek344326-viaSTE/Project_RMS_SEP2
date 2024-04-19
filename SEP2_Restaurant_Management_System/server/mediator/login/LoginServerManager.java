package server.mediator.login;

import server.model.login.LoginModel;
import sharedResources.networking.serverInterfaces.LoginServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerManager implements LoginServer {
    private LoginModel loginModel;

    public LoginServerManager(LoginModel loginModel) throws RemoteException {
        this.loginModel = loginModel;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public String isLoginPossible(String username, String password) throws RemoteException {
        return loginModel.login(username, password);
    }

    @Override
    public String signUp(String userName, String password) throws RemoteException{
      return loginModel.signUp(userName, password);
    }
}
