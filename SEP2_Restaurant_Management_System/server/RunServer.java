package server;

import server.mediator.ServerManager;
import server.mediator.login.LoginServerManager;
import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import sharedResources.networking.serverInterfaces.LoginServer;
import sharedResources.networking.serverInterfaces.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
            LoginModel loginModel = new LoginModelManager();
            LoginServer loginServer = new LoginServerManager(loginModel);
            Server server = new ServerManager(loginServer);
            server.startServer();
    }
}
