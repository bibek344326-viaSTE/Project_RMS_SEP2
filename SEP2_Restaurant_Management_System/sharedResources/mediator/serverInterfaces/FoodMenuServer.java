package sharedResources.mediator.serverInterfaces;

import sharedResources.utils.Request;
import sharedResources.utils.foodmenu.Foodmenu;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FoodMenuServer extends Remote {
    ArrayList<Foodmenu> getMenu() throws RemoteException;

    void addMenuItem(String newName, String type) throws RemoteException;

    Request editMenu (Foodmenu foodmenu) throws RemoteException;

    void deleteMenu(Foodmenu foodmenu) throws RemoteException;

}

