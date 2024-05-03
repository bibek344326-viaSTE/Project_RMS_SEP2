package client.model.foodmenu;

import sharedResources.utils.foodmenu.foodmenu;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface FoodmenuModel {
    void addFoodItem(String name, int price);
    void deleteFoodItem(String name);
    int getNumberOfFoodItems();
    ArrayList<foodmenu> getAllFoodItems();

}
