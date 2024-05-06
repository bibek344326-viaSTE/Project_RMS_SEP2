package client.model.foodmenu;

import sharedResources.utils.foodmenu.Foodmenu;

import java.util.ArrayList;

public interface FoodmenuModel {
    void addFoodItem(String name, String type);
    void editFoodItem(String name, String type);
    void deleteFoodItem(String name);
    int getNumberOfFoodItems();
    ArrayList<Foodmenu> getAllFoodItems();

}
