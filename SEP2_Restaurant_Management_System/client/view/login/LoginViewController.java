package client.view.login;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class LoginViewController implements ViewController {
    @FXML
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.loginViewModel = viewModelFactory.getLogInViewModel();
        this.viewHandler = viewHandler;

    }

    /*@FXML
     private void LoginButtonClicked(ActionEvent actionEvent) {
         loginViewModel.login("Successfully logged in");
         viewHandler.openTableView();
     }*/

    @FXML
    private void customerButtonPressed() {
        viewHandler.openCustomerView();
    }

    @FXML
    private void staffMemberButtonPressed() {
        viewHandler.openStaffView();
    }

    @FXML
    private void kitchenStaffButtonPressed() {
        viewHandler.openTableView();

    }
}