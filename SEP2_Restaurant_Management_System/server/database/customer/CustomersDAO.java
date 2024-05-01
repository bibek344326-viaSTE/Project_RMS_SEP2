package server.database.customer;

import sharedResources.utils.Customer.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomersDAO {
    ArrayList<Customer> getAllCustomers() throws SQLException;
    void addCustomer(Customer customer) throws SQLException;
    void updateCustomer(Customer customer) throws SQLException;
    void deleteCustomer(Customer customer) throws SQLException;

}
