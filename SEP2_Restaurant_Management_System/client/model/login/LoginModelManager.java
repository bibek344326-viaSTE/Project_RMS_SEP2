package client.model.login;

import client.mediator.Client;
import client.mediator.login.LoginClient;
import client.model.login.LoginModel;

public class LoginModelManager implements LoginModel {
    private final LoginClient loginClient;

    public LoginModelManager(LoginClient client) {
        this.loginClient = client;
    }

    @Override
    public void login(String hi) {
        loginClient.login(hi);
    }

    @Override
    public void signUp(String userName, String password) {
        loginClient.signUp(userName, password);
    }
}
