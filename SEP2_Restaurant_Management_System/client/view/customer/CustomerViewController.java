package client.view.customer;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import javafx.fxml.FXML;

public class CustomerViewController implements ViewController {
    @FXML
    private CustomerViewModel customerViewModel;
    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

   /* public void clearTableForCustomer() {
        Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerViewModel.clearTableForCustomer(selectedCustomer);
        } else {
            System.out.println("Please select a customer.");
        }
    }*/


    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler) {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }

    public void proceedToMenuItems() {
        viewHandler.openMenuItemsView();
    }
}