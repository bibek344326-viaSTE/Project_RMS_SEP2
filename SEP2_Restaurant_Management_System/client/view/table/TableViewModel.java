package client.view.table;

import client.model.Reservation.ReservationModel;
import client.model.table.TableModel;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TableViewModel implements PropertyChangeListener {

    private ObservableList<Table> tableList;
    private TableModel model;
    private TableView<Table> tableView;
    private ReservationModel reservationmodel;
    private StringProperty errorProperty;

    public TableViewModel(TableModel model,ReservationModel reservationmodel) {
        this.model = model;
        this.model.addListener(this);
        tableList = FXCollections.observableArrayList();
        this.reservationmodel = reservationmodel;
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

            errorProperty.set("Table " + selectedTable.getTableNumber() + " status updated.");
        } else {
            errorProperty.set("Please select a table to edit.");
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
            errorProperty.set("Table " + selectedTable.getTableNumber() + " reserved.");
        } else {
            errorProperty.set("Please select an available table to reserve ");
        }
    }

    public void vacateTable() {
        Table selectedTable = tableView.getSelectionModel().getSelectedItem();
        if (selectedTable != null && selectedTable.isOccupied()) {
            selectedTable.setOccupied(false); // Mark the table as unoccupied (available)
            model.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied()); // Update the table status
            updateTableList();
            errorProperty.set("Table " + selectedTable.getTableNumber() + " reservation cancelled.");
        } else {
            errorProperty.set("Please select an occupied table to cancel reservation ");
        }
    }
    public void addReservation(int tableNumber) {
        Reservation reservation = reservationmodel.findReservationByTable(tableNumber);
        if (reservation != null) {
            Table selectedTable = model.getTableByNumber(tableNumber);
            if (selectedTable != null && !selectedTable.isOccupied()) {
                selectedTable.setOccupied(true);
                model.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied());
                updateTableList();
                errorProperty.set("Table " + selectedTable.getTableNumber() + " reserved.");
            } else {
                errorProperty.set("Table " + tableNumber + " is either occupied or does not exist.");
            }
        } else {
            errorProperty.set("No reservation found for table " + tableNumber + ".");
        }
    }

    public void removeReservation(int tableNumber) {
        Reservation reservation = reservationmodel.findReservationByTable(tableNumber);
        if (reservation != null) {
            Table selectedTable = model.getTableByNumber(tableNumber);
            if (selectedTable != null && selectedTable.isOccupied()) {
                selectedTable.setOccupied(false);
                model.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied());
                updateTableList();
                errorProperty.set("Table " + selectedTable.getTableNumber() + " reservation cancelled.");
            } else {
                errorProperty.set("Table " + tableNumber + " is either not occupied or does not exist.");
            }
        } else {
            errorProperty.set("No reservation found for table " + tableNumber + ".");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("tableList")) {
            updateTableList();
        }
    }


}
