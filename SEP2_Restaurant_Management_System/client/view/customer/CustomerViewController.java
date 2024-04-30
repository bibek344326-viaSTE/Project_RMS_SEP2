package client.view.customer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sharedResources.utils.Customer.Customer;

public class CustomerViewController {
    @FXML
    private ComboBox<Customer> customerComboBox;
    private CustomerViewModel customerViewModel;

    public void clearTableForCustomer() {
        Customer selectedCustomer = customerComboBox.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            customerViewModel.clearTableForCustomer(selectedCustomer);
        } else {
            System.out.println("Please select a customer.");
        }
    }

    public void init(CustomerViewModel customerViewModel, ObservableList<Customer> customers) {
        this.customerViewModel = customerViewModel;
        customerComboBox.setItems(customers);
    }



}