package client.model.table;

import sharedResources.utils.table.Table;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TableListModelManager implements TableModel {
    private final TableList tableList;
    private final PropertyChangeSupport property;

    public TableListModelManager() {
        property = new PropertyChangeSupport(this);
        tableList = new TableList();
        createDummyData();
    }

    private void createDummyData() {
        createTable(1, 4);
        createTable(2, 2);
        createTable(3, 6);
    }

    @Override
    public void createTable(int tableNumber, int capacity) {
        tableList.createTable(tableNumber, capacity);
        property.firePropertyChange("TableCreated", null, tableNumber);
    }

    @Override
    public void deleteTable(int tableNumber) {
        tableList.deleteTable(tableNumber);
        property.firePropertyChange("TableDeleted", tableNumber, null);
    }

    @Override
    public void updateTable(int tableNumber, boolean isOccupied) {
        tableList.updateTable(tableNumber, isOccupied);
        property.firePropertyChange("TableUpdated", tableNumber, isOccupied);
    }

    @Override
    public int getNumberOfTables() {
        return tableList.getNumberOfTables();
    }

    @Override
    public ArrayList<Table> getAllTables() {
        return tableList.getAllTables();
    }

    @Override
    public ArrayList<Table> getVacantTables() {
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