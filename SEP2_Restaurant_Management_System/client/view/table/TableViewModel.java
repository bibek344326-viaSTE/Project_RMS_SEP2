package client.view.table;

import client.core.ModelFactory;
import client.core.ViewState;
import client.model.Reservation.ReservationModel;
import client.model.table.TableModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import sharedResources.utils.Reservation.Reservation;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TableViewModel implements PropertyChangeListener {

    private ObservableList<SimpleTableViewModel> tableList;
    private TableModel tablemodel;
    private ObjectProperty<SimpleTableViewModel> selectedTableProperty;
    private ReservationModel reservationmodel;



    public StringProperty getErrorProperty() {
        return errorLabel;
    }

    private StringProperty errorLabel;
    private ViewState viewState;

    public TableViewModel(ModelFactory modelFactory, ViewState viewState) {
        this.tablemodel = modelFactory.getTableModel();
        this.reservationmodel = modelFactory.getReservationModel();
        tableList = FXCollections.observableArrayList();
        this.selectedTableProperty = new SimpleObjectProperty<>();
        this.errorLabel = new SimpleStringProperty();
        tablemodel.addListener(this);
        reservationmodel.addListener(this);
        this.viewState = viewState;
        updateTableList();

    }
    public ObservableList<SimpleTableViewModel> getTableList() {
        return tableList;
    }
    public void updateTableList(){
        tableList.clear();
        for(int i = 0; i < tablemodel.getAllTables().size(); i++){
            tableList.add(new SimpleTableViewModel(tablemodel.getAllTables().get(i)));
        }
    }


    public void setSelected(SimpleTableViewModel table){
        if (table == null){
            viewState.setTablenumber(0);
            viewState.setCapacity(0);
            viewState.setStatus(false);
        }
        else{
            this.selectedTableProperty.set(table);
            viewState.setTablenumber(selectedTableProperty.get().getTableNumberProperty().get());
            viewState.setCapacity(selectedTableProperty.get().getCapacityProperty().get());
            viewState.setStatus(false);
        }
    }

    public void deselect(){
        setSelected(null);
//    viewState.setTitle(null);
//    viewState.setState(null);
//    viewState.setRemove(false);
    }


    public void addNewTable() {
        int nextTableNumber = tableList.size() + 1;
        int capacity = 6;
        tablemodel.createTable(nextTableNumber, capacity); // Create a new table
        updateTableList();
    }

    public void updateTableDetails() {
        SimpleTableViewModel selectedTable = selectedTableProperty.get();
        if (selectedTable != null) {
            int tableIndex = tableList.indexOf(selectedTable);
            if (tableIndex != -1) {
                boolean newOccupiedStatus = !selectedTable.getStatusProperty().get();
                tablemodel.updateTable(selectedTable.getTableNumberProperty().get(), newOccupiedStatus); // Update the table status in the model
                updateTableList();
                errorLabel.set("Table " + selectedTable.getTableNumberProperty().get() + " status updated.");
            } else {
                errorLabel.set("Selected table not found in the list.");
            }
        } else {
            errorLabel.set("Please select a table to edit.");
        }
    }

    public void deleteTable() {
        SimpleTableViewModel selectedTable = selectedTableProperty.get();
        if (selectedTable != null) {
            tablemodel.deleteTable(selectedTable.getTableNumberProperty().get()); // Delete the selected table
            updateTableList();
        }
    }

    public void occupyTable() {
        SimpleTableViewModel selectedTable = selectedTableProperty.get();
        if (selectedTable != null && !selectedTable.getStatusProperty().get()) {
            tablemodel.updateTable(selectedTable.getTableNumberProperty().get(), true); // Mark the table as occupied (reserved)
            updateTableList();
            errorLabel.set("Table " + selectedTable.getTableNumberProperty().get() + " reserved.");
        } else {
            errorLabel.set("Please select an available table to reserve ");
        }
    }

    public void vacateTable() {
        SimpleTableViewModel selectedTable = selectedTableProperty.get();
        if (selectedTable != null && selectedTable.getStatusProperty().get()) {
            tablemodel.updateTable(selectedTable.getTableNumberProperty().get(), false); // Mark the table as unoccupied (available)
            updateTableList();
            errorLabel.set("Table " + selectedTable.getTableNumberProperty().get() + " reservation cancelled.");
        } else {
            errorLabel.set("Please select an occupied table to cancel reservation ");
        }
    }
    public void addReservation(int tableNumber) {
        Reservation reservation = reservationmodel.findReservationByTable(tableNumber);
        if (reservation != null) {
            Table selectedTable = tablemodel.getTableByNumber(tableNumber);
            if (selectedTable != null && !selectedTable.isOccupied()) {
                selectedTable.setOccupied(true);
                tablemodel.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied());
                updateTableList();
                errorLabel.set("Table " + selectedTable.getTableNumber() + " reserved.");
            } else {
                errorLabel.set("Table " + tableNumber + " is either occupied or does not exist.");
            }
        } else {
            errorLabel.set("No reservation found for table " + tableNumber + ".");
        }
    }

    public void removeReservation(int tableNumber) {
        Reservation reservation = reservationmodel.findReservationByTable(tableNumber);
        if (reservation != null) {
            Table selectedTable = tablemodel.getTableByNumber(tableNumber);
            if (selectedTable != null && selectedTable.isOccupied()) {
                selectedTable.setOccupied(false);
                tablemodel.updateTable(selectedTable.getTableNumber(), selectedTable.isOccupied());
                updateTableList();
                errorLabel.set("Table " + selectedTable.getTableNumber() + " reservation cancelled.");
            } else {
                errorLabel.set("Table " + tableNumber + " is either not occupied or does not exist.");
            }
        } else {
            errorLabel.set("No reservation found for table " + tableNumber + ".");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("tableList")) {
            updateTableList();
        }
    }


}