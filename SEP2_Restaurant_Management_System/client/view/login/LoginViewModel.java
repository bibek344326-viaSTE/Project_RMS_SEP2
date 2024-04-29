package client.view.login;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import client.view.ViewHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sharedResources.utils.Staff.Chef;
import sharedResources.utils.Staff.StaffMember;

import java.util.ArrayList;
import java.util.List;

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



    // Method to handle combo box selection
    public void handleComboBoxSelection(Object selectedItem) {
        if (selectedItem instanceof StaffMember) {
            StaffMember selectedStaffMember = (StaffMember) selectedItem;
            System.out.println("Selected Staff Member: " + selectedStaffMember.getName());
        } else if (selectedItem instanceof Chef) {
            Chef selectedChef = (Chef) selectedItem;
            System.out.println("Selected Chef: " + selectedChef.getName());
        }
    }


}
