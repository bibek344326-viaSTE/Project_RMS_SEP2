package client.mediator.foodmenu;

import client.mediator.RemoteClientRMI;
import sharedResources.mediator.serverInterfaces.FoodMenuServer;
import sharedResources.mediator.serverInterfaces.TableServer;

import java.rmi.RemoteException;

public class FoodMenuClientManager implements FoodMenuClient{
    private final FoodMenuServer foodMenuServer;

    public FoodMenuClientManager() throws RemoteException {
        this.foodMenuServer = RemoteClientRMI.getServerFromRMI().getFoodMenuServer();
    }

    @Override
    public void addFoodItem(String name, String type) {
        try {
            // Call the method on the FoodMenuServer to add the food item
            foodMenuServer.addMenuItem(name, type);
            System.out.println("Food item added successfully: " + name);
        } catch (RemoteException e) {
            System.err.println("Error adding food item: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
