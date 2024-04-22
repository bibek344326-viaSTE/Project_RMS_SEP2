package client.model.table;

import sharedResources.utils.table.Table;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;

public interface TableManagement extends UnnamedPropertyChangeSubject {
    void createTable(int tableNumber, int capacity);

    void updateTable(int tableNumber, boolean isOccupied);

    void deleteTable(int tableNumber);

    ArrayList<Table> getAllTables();
}
