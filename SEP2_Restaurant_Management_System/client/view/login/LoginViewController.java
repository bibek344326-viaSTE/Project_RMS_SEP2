package client.view.login;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import sharedResources.utils.Staff.Chef;
import sharedResources.utils.Staff.StaffMember;

public class LoginViewController implements ViewController {
    @FXML
    private ComboBox<Object> comboBox;
    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.loginViewModel = viewModelFactory.getLogInViewModel();
        this.viewHandler = viewHandler;

       /* ObservableList<Object> items = FXCollections.observableArrayList();
        items.addAll(loginViewModel.getStaffMembers());
        items.addAll(loginViewModel.getChefs());
        comboBox.setItems(items);*/
    }

    @FXML
    private void LoginButtonClicked(ActionEvent actionEvent) {
        loginViewModel.login("Successfully logged in");
        viewHandler.openTableView();
    }


    public void onComboBoxSelection(ActionEvent actionEvent) {
        Object selectedItem = comboBox.getValue();
        if (selectedItem instanceof StaffMember) {
            StaffMember selectedStaffMember = (StaffMember) selectedItem;
            System.out.println("Selected Staff Member: " + selectedStaffMember.getName());
        } else if (selectedItem instanceof Chef) {
            Chef selectedChef = (Chef) selectedItem;
            System.out.println("Selected Chef: " + selectedChef.getName());
        }
    }
}
