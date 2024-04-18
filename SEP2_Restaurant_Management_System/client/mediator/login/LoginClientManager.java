package client.mediator.login;

import client.mediator.RemoteClientRMI;
import sharedResources.networking.serverInterfaces.LoginServer;

import java.rmi.RemoteException;

public class LoginClientManager implements LoginClient {
    private LoginServer server;

    public LoginClientManager() throws RemoteException {
        this.server = RemoteClientRMI.getServerFromRMI().getLoginServer();
    }

    @Override
    public void login(String hi) {
        try {
            String loginOK = server.isLoginPossible(hi, "abc");
            System.out.println(loginOK);
        } catch (RemoteException e) {
            System.out.println("error in " +
                    "LoginClientManager"
            );
            throw new RuntimeException(e);
        }
    }

    @Override
    public void signUp(String userName, String password) {
        String signUpSucess = null;
        try {
            signUpSucess = server.signUp(userName, password);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        System.out.println("signupOK"  + signUpSucess);
    }
}
