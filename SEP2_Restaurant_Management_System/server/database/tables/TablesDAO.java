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

    void createTable(int tableNumber, int tableCapacity) throws SQLException;

    void deleteTable(int tableNumber) throws SQLException;

    void updateTable(int tableNumber, int tableCapacity) throws SQLException;

    ArrayList<Table> getOccupiedTables() throws SQLException;

    ArrayList<Table> getVacantTables() throws SQLException;
}
