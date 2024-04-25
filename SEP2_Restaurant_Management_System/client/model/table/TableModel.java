package client.model.table;

import sharedResources.utils.table.Table;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;
import java.util.ArrayList;

public interface TableModel extends UnnamedPropertyChangeSubject {
    void createTable(int tableNumber, int capacity);

    void updateTable(int tableNumber, boolean isOccupied);

    void deleteTable(int tableNumber);

    ArrayList<Table> getAllTables();

    int getNumberOfTables();

    ArrayList<Table> getVacantTables();

    Table getTableByNumber(int tableNumber);
}