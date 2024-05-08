package sharedResources.utils.table;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
import sharedResources.utils.Customer.Customer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Table implements UnnamedPropertyChangeSubject {

    private int tableNumber;
    private boolean isOccupied;
    private int capacity;
    private PropertyChangeSupport property;
    private Customer customer; // Add instance of Customer

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Customer getCustomer() { // Getter for customer
        return customer;
    }

    public void setCustomer(Customer customer) { // Setter for customer
        this.customer = customer;
    }

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
        this.property = new PropertyChangeSupport(this);
    }

    public void occupyTable(Customer customer) { // Modify occupyTable to accept Customer
        if (!isOccupied) {
            boolean oldOccupied = isOccupied;
            isOccupied = true;
            this.customer = customer; // Set customer
            System.out.println("Table " + tableNumber + " has been occupied by " + customer.getName());
            property.firePropertyChange("isOccupied", oldOccupied, isOccupied);
        } else {
            System.out.println("Table " + tableNumber + " is already occupied.");
        }
    }

    public void vacateTable() {
        if (isOccupied) {
            boolean oldOccupied = isOccupied;
            isOccupied = false;
            this.customer = null; // Clear customer when table is vacated
            System.out.println("Table " + tableNumber + " has been vacated.");
            property.firePropertyChange("isOccupied", oldOccupied, isOccupied);
        } else {
            System.out.println("Table " + tableNumber + " is already vacant.");
        }
    }

    public String getCustomerName() { // Method to retrieve customer's name
        if (customer != null) {
            return customer.getName();
        } else {
            return "N/A";
        }
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", isOccupied=" + isOccupied +
                ", capacity=" + capacity +
                ", customer=" + customer +
                '}';
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}