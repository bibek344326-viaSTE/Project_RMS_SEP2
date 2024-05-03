package client.model.foodmenu;

import sharedResources.utils.foodmenu.foodmenu;
import java.util.ArrayList;

public interface FoodmenuModel {
    void addFoodItem(String name, String description); // Adjusted parameter from int price to String description
    void deleteFoodItem(String name);
    int getNumberOfFoodItems();
    ArrayList<foodmenu> getAllFoodItems();
}
