package server;

import server.database.customer.CustomerDAOManager;
import server.database.customer.CustomersDAO;
import server.database.reservations.ReservationDAO;
import server.database.reservations.ReservationDAOManager;
import server.database.tables.TablesDAO;
import server.database.tables.TablesDAOManager;
import server.mediator.ServerManager;
import server.mediator.login.LoginServerManager;
import server.model.login.LoginModel;
import server.model.login.LoginModelManager;
import sharedResources.networking.serverInterfaces.LoginServer;
import sharedResources.networking.serverInterfaces.Server;
import sharedResources.utils.Customer.Customer;
import sharedResources.utils.table.Table;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SQLException {
        LoginModel loginModel = new LoginModelManager();
        LoginServer loginServer = new LoginServerManager(loginModel);
        Server server = new ServerManager(loginServer);
        server.startServer();

        TablesDAO tablesDAO = new TablesDAOManager();
       // tablesDAO.createTable(new Table(4, 10));
        ArrayList<Table> tables = tablesDAO.getTables();
        for (Table table : tables) {
            System.out.println("Table number: " + table.getTableNumber() + "       Table Capacity: " + table.getCapacity());
        }
        CustomersDAO customersDAO = new CustomerDAOManager();
        customersDAO.addCustomer(new Customer("Bibek"));
        ReservationDAO reservationDAO = new ReservationDAOManager();
        reservationDAO.addReservation(3,1, LocalDateTime.now());

    }

}
