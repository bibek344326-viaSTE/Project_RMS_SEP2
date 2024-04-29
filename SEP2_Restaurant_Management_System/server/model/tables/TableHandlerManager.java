package server.model.tables;

import sharedResources.utils.Request;
import sharedResources.utils.table.Table;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;

public class TableHandlerManager implements TableHandler {
    private PropertyChangeSupport support;

    public TableHandlerManager() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public Request searchTable(LocalDate date) {
        return null;
    }

    @Override
    public String getTableName(Table table) {
        return "";
    }

    @Override
    public ArrayList<Table> getTables() {
        return null;
    }

    @Override
    public void updateTable(Table table, String newName, int tableSize) {

    }

    @Override
    public void deleteTable(Table table) {

    }

    @Override
    public void reserveTable() {

    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}