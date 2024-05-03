package client.model.table;

import sharedResources.utils.table.Table;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import sharedResources.utils.table.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TableList implements PropertyChangeListener {
    private ArrayList<Table> tables;

    public TableList() {
        tables = new ArrayList<>();
    }

    // Method to create a new table
    public void createTable(int tableNumber, int capacity) {
        Table newTable = new Table(tableNumber, capacity);
        tables.add(newTable);
    }

    // Method to delete a table
    public void deleteTable(int tableNumber) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getTableNumber() == tableNumber) {
                tables.remove(i);
                break;
            }
        }
    }
    public Table getTableByNumber(int tableNumber) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                return table;
            }
        }
        return null; // Table not found
    }

    // Method to update the status of a table
    public void updateTable(int tableNumber, boolean isOccupied) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                if (isOccupied) {
                    table.occupyTable();
                } else {
                    table.vacateTable();
                }
                break;
            }
        }
    }

    // Method to get the number of tables
    public int getNumberOfTables() {
        return tables.size();
    }

    // Method to get all tables
    public ArrayList<Table> getAllTables() {
        return this.tables;
    }

    public ArrayList<Table> getVacantTables() {
        ArrayList<Table> vacantTables = new ArrayList<>();
        for (Table table : tables) {
            if (!table.isOccupied()) {
                vacantTables.add(table);
            }
        }
        return vacantTables;
    }
    public void add(Table table){this.tables.add(table);}

    @Override
    public String toString() {
        return "TableList{" +
                "tables=" + tables +
                '}';
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("isOccupied")) {
            boolean newOccupied = (boolean) evt.getNewValue();
            int tableNumber = ((Table) evt.getSource()).getTableNumber();

            if (newOccupied) {
                System.out.println("Table " + tableNumber + " has been occupied.");
            } else {
                System.out.println("Table " + tableNumber + " has been vacated.");
            }

        }

    }
}