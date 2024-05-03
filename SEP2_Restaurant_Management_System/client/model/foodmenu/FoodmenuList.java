package client.model.foodmenu;

import sharedResources.utils.foodmenu.foodmenu;
import java.util.ArrayList;

public class FoodmenuList  {
    private ArrayList<foodmenu> foodItems;

    public FoodmenuList() {
        foodItems = new ArrayList<>();
    }

    // Method to add a new food item
    public void addFoodItem(String name, String description) {
        foodmenu newFoodItem = new foodmenu(name, description);
        foodItems.add(newFoodItem);
    }

    // Method to delete a food item by name
    public void deleteFoodItem(String name) {
        foodItems.removeIf(item -> item.getName().equals(name));
    }

    // Method to get the number of food items
    public int getNumberOfFoodItems() {
        return foodItems.size();
    }

    // Method to get all food items
    public ArrayList<foodmenu> getAllFoodItems() {
        return new ArrayList<>(foodItems);
    }

    @Override
    public String toString() {
        return "FoodmenuList{" +
                "foodItems=" + foodItems +
                '}';
    }

}