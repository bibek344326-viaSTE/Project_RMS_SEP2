package client.core;

import client.view.login.LoginViewModel;

public class ViewModelFactory {

    private final ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }
    public LoginViewModel getLogInViewModel() {
        if (loginViewModel == null){
            loginViewModel = new LoginViewModel(modelFactory);
        }
        return loginViewModel;
    }

}
