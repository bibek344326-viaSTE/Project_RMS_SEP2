package client.model.login;

import client.mediator.Client;
import client.model.login.LoginModel;

public class LoginModelManager implements LoginModel {
    private final Client client;

    public LoginModelManager(Client client) {
        this.client = client;
    }

    @Override
    public void login(String hi) {
        client.login(hi);
    }
}
