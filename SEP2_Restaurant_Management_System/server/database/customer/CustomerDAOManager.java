package server.database.customer;

import server.database.DatabaseConnection;
import sharedResources.utils.Customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOManager implements CustomersDAO{

    private ArrayList<Customer> getCustomers(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            int customerId = resultSet.getInt("customer_id");
            String name = resultSet.getString("name");
            String phoneNumber = resultSet.getString("phoneNumber");
            Customer customer = new Customer(name);
            customers.add(customer);
        }
        return customers;
    }


    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM customer");
            return getCustomers(preparedStatement);
        }
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO customer (name, phoneNumber) VALUES (?, ?)");

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhoneNumber());
            preparedStatement.executeUpdate();

            System.out.println("Customer added successfully.");
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE customer SET name = ?, phoneNumber = ? WHERE customer_id = ?");

            preparedStatement.setString(1, customer.getName());
            //preparedStatement.setString(2, customer.getPhoneNumber());
            //preparedStatement.setInt(3, customer.getCustomerId());
            preparedStatement.executeUpdate();

            System.out.println("Customer updated successfully.");
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM customer WHERE customer_id = ?");

            //preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();

            System.out.println("Customer deleted successfully.");
        }
    }
}
