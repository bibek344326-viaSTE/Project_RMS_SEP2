package client.model.table;

import client.mediator.table.TableClient;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;


public class TableModelManager implements TableModel {
    private final TableList tableList;
    private final PropertyChangeSupport property;
    private final TableClient tableClient;

    public TableModelManager(TableClient tableClient) {
        this.tableList = new TableList();
        this.property = new PropertyChangeSupport(this);
        this.tableClient = tableClient;
    }


    public void createTable(int tableNumber, int capacity) {
        // TODO : change all the method from table list to table server and move table list to server section
        tableList.createTable(tableNumber, capacity);
        property.firePropertyChange("TableCreated", null, tableNumber);
    }

    public void deleteTable(int tableNumber) {
        tableList.deleteTable(tableNumber);
        property.firePropertyChange("TableDeleted", tableNumber, null);
    }

    public void updateTable(int tableNumber, boolean isOccupied) {
        tableList.updateTable(tableNumber, isOccupied);
        property.firePropertyChange("TableUpdated", tableNumber, isOccupied);
    }

    public int getNumberOfTables() {
        return tableList.getNumberOfTables();
    }

    public ArrayList<Table> getAllTables() {
        return tableList.getAllTables();
    }
    public ArrayList<Table> getVacantTables(){
        return tableList.getVacantTables();
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
