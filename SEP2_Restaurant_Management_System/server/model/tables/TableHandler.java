package server.model.tables;

import sharedResources.utils.Request;
import sharedResources.utils.Subject;
import sharedResources.utils.table.Table;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TableHandler extends Subject {
    Request searchTable(LocalDate date);
    String getTableName(Table table);
    ArrayList<Table> getTables();
    void updateTable(Table table, String newName, int tableSize);
    void deleteTable(Table table);

    void reserveTable();
}
