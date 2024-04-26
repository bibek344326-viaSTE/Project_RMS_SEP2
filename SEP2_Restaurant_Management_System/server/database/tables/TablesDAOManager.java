package server.database.tables;

import server.database.DatabaseConnection;
import sharedResources.utils.table.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablesDAOManager implements TablesDAO {
    @Override
    public void createTable(Table table) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("INSERT INTO tables (table_number, table_capacity) VALUES (?,?)");

            preparedStatement.setInt(1, table.getTableNumber());
            preparedStatement.setInt(2, table.getCapacity());
            preparedStatement.executeUpdate();

            System.out.println("Table added successfully.");
        }
    }

    @Override
    public void deleteTable(Table table) throws SQLException {

    }

    @Override
    public void updateTable(Table table) throws SQLException {

    }

    @Override
    public ArrayList<Table> getTables() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM tables");
            return (ArrayList<Table>) getTable(preparedStatement);
        }
    }

    private ArrayList<Table> getTable(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Table> tables = new ArrayList<>();
        while (resultSet.next()) {
            int tableNumber = resultSet.getInt("table_number");
            int capacity = resultSet.getInt("table_capacity");
            Table table = new Table(tableNumber, capacity);
            tables.add(table);
        }
        return tables;
    }

    @Override
    public Table getTable(String tableNumber) throws SQLException {
        return null;
    }
}
