package client.view.table;

import client.model.table.TableManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TableViewModel implements PropertyChangeListener {

    private ObservableList<Table> tableList;
    private TableManagement model;
    private TableView<Table> tableView;

    public TableViewModel(TableManagement model) {
        this.model = model;
        this.model.addListener(this);
        tableList = FXCollections.observableArrayList();
        updateTableList();

    }
    public ObservableList<Table> getTableList() {
        return tableList;
    }

    private void updateTableList() {
        tableList.clear();
        tableList.addAll(model.getAllTables());
    }

    public void addNewTable() {
        int nextTableNumber = tableList.size() + 1;
        int capacity = 6;
        model.createTable(nextTableNumber, capacity); // Create a new table
        updateTableList();
    }

    public void updateTableDetails() {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            Table selectedTable = tableList.get(selectedIndex);


            boolean newOccupiedStatus = !selectedTable.isOccupied();
            model.updateTable(selectedTable.getTableNumber(), newOccupiedStatus); // Update the table status in the model

            updateTableList();

            System.out.println("Table " + selectedTable.getTableNumber() + " status updated.");
        } else {
            System.out.println("Please select a table to edit.");
        }
    }

    public void deleteTable() {
        Table selectedTable = tableList.get(tableView.getSelectionModel().getSelectedIndex());
        if (selectedTable != null) {
            model.deleteTable(selectedTable.getTableNumber()); // Delete the selected table
            updateTableList();
        }
    }
    public void occupyTable() {
        Table selectedTable = tableView.getSelectionModel().getSelectedItem();
        if (selectedTable != null && !selectedTable.isOccupied()) {
            selectedTable.setOccupied(true); // Mark the table as occupied (reserved)
            model.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied()); // Update the table status
            updateTableList();
            System.out.println("Table " + selectedTable.getTableNumber() + " reserved.");
        } else {
            System.out.println("Please select an available table to reserve ");
        }
    }

    public void vacateTable() {
        Table selectedTable = tableView.getSelectionModel().getSelectedItem();
        if (selectedTable != null && selectedTable.isOccupied()) {
            selectedTable.setOccupied(false); // Mark the table as unoccupied (available)
            model.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied()); // Update the table status
            updateTableList();
            System.out.println("Table " + selectedTable.getTableNumber() + " reservation cancelled.");
        } else {
            System.out.println("Please select an occupied table to cancel reservation ");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("tableList")) {
            updateTableList();
        }
    }


}
