package client.view.login;
import client.core.ModelFactory;
import client.model.login.LoginModel;

public class LoginViewModel {

    private final LoginModel loginModel;

    public LoginViewModel(ModelFactory modelFactory) {
        this.loginModel = modelFactory.getLoginModel();
        // bind textarea over here
    }

    public void login(String tableView) {
        // change name of argument better option is to create User and send Request obj
        loginModel.login(tableView);
    }


    }


