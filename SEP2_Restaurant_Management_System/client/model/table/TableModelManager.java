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
        createDummyData();
    }



        // TODO : change all the method from table list to table server and move table list to server section
        private void createDummyData() {
         tableList.add(new Table(1, 4));
         tableList.add(new Table(2, 5));
         tableList.add(new Table(3, 7));
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
    public Table getTableByNumber(int tableNumber) {return tableList.getTableByNumber(tableNumber);}


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