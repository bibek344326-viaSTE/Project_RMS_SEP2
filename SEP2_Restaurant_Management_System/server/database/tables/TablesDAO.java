package server.database.tables;

import sharedResources.utils.table.Table;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TablesDAO {
    void createTable(Table table) throws SQLException;

    void deleteTable(Table table) throws SQLException;

    void updateTable(Table table) throws SQLException;

    ArrayList<Table> getTables() throws SQLException;

    Table getTable(String tableNumber) throws SQLException;
}
