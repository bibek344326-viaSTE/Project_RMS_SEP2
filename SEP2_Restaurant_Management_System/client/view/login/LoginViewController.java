package client.view.login;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginViewController implements ViewController {
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.loginViewModel = viewModelFactory.getLogInViewModel();
        this.viewHandler = viewHandler;
    }

    @FXML
    private void LoginButtonClicked(ActionEvent actionEvent) {
        loginViewModel.login("HI this is chana");
    }

    @FXML
    private void SignUpButtonClicked(ActionEvent actionEvent) {
        loginViewModel.signUp("Rachana" , "password");
    }
}
