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
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO tables (table_number, table_capacity, is_occupied) VALUES (?,?,?)");

            preparedStatement.setInt(1, table.getTableNumber());
            preparedStatement.setInt(2, table.getCapacity());
            preparedStatement.setBoolean(3, table.isOccupied());
            preparedStatement.executeUpdate();

            System.out.println("Table added successfully.");
        }
    }

    @Override
    public void createTable(int tableNumber, int tableCapacity) throws SQLException {
        // Assuming table is not occupied by default when creating
        createTable(new Table(tableNumber, tableCapacity, false));
    }

    @Override
    public void deleteTable(Table table) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM tables WHERE table_number = ?");
            preparedStatement.setInt(1, table.getTableNumber());
            preparedStatement.executeUpdate();

            System.out.println("Table deleted successfully.");
        }
    }

    @Override
    public void deleteTable(int tableNumber) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM tables WHERE table_number = ?");
            preparedStatement.setInt(1, tableNumber);
            preparedStatement.executeUpdate();

            System.out.println("Table deleted successfully.");
        }
    }

    @Override
    public void updateTable(int tableNumber, int tableCapacity) throws SQLException {
        // For this method, we won't update the isOccupied status
        // You can provide another method to update isOccupied if needed
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE tables SET table_capacity = ? WHERE table_number = ?");
            preparedStatement.setInt(1, tableCapacity);
            preparedStatement.setInt(2, tableNumber);
            preparedStatement.executeUpdate();

            System.out.println("Table updated successfully.");
        }
    }

    @Override
    public void updateTable(Table table) throws SQLException {
        updateTable(table.getTableNumber(), table.getCapacity());
    }

    @Override
    public ArrayList<Table> getTables() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tables");
            return getTable(preparedStatement);
        }
    }

    private ArrayList<Table> getTable(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Table> tables = new ArrayList<>();
        while (resultSet.next()) {
            int tableNumber = resultSet.getInt("table_number");
            int capacity = resultSet.getInt("table_capacity");
            boolean isOccupied = resultSet.getBoolean("is_occupied");
            Table table = new Table(tableNumber, capacity, isOccupied);
            tables.add(table);
        }
        return tables;
    }

    @Override
    public Table getTable(String tableNumber) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tables WHERE table_number = ?");
            preparedStatement.setString(1, tableNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int tableNum = resultSet.getInt("table_number");
                int tableCapacity = resultSet.getInt("table_capacity");
                boolean isOccupied = resultSet.getBoolean("is_occupied");

                return new Table(tableNum, tableCapacity, isOccupied);
            } else {
                // Table not found
                return null;
            }
        }
    }

    @Override
    public ArrayList<Table> getOccupiedTables() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tables WHERE is_occupied = ?");
            preparedStatement.setBoolean(1, true);

            return getTable(preparedStatement);
        }
    }

    @Override
    public ArrayList<Table> getVacantTables() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM tables WHERE is_occupied = ?");
            preparedStatement.setBoolean(1, false);

            return getTable(preparedStatement);
        }
    }
}