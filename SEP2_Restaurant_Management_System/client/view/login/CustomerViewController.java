package client.view.login;

import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.ViewHandler;
import client.view.customer.CustomerViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import sharedResources.utils.Customer.Customer;

public class CustomerViewController implements ViewController {
    @FXML
    private ComboBox<Customer> customerComboBox;
    private CustomerViewModel customerViewModel;
    private ViewModelFactory viewModelFactory;
    private ViewHandler viewHandler;

    public void clearTableForCustomer() {
        Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerViewModel.clearTableForCustomer(selectedCustomer);
        } else {
            System.out.println("Please select a customer.");
        }
    }

   /* public void init(CustomerViewModel customerViewModel, ObservableList<Customer> customers) {
        this.customerViewModel = customerViewModel;
        customerComboBox.setItems(customers);
    }*/


    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler, Region root) {
        this.viewModelFactory = viewModelFactory;
        this.viewHandler = viewHandler;
    }
}