package client.model.foodmenu;

import sharedResources.utils.foodmenu.foodmenu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class FoodmenuList implements PropertyChangeListener {
    private ArrayList<foodmenu> foodItems;

    public FoodmenuList() {
        foodItems = new ArrayList<>();
    }

    // Method to add a new food item
    public void addFoodItem(String name, int price) {
        foodmenu newFoodItem = new foodmenu(name, price);
        foodItems.add(newFoodItem);
    }

    // Method to delete a food item by name
    public void deleteFoodItem(String name) {
        for (int i = 0; i < foodItems.size(); i++) {
            if (foodItems.get(i).getName().equals(name)) {
                foodItems.remove(i);
                break;
            }
        }
    }

    // Method to get the number of food items
    public int getNumberOfFoodItems() {
        return foodItems.size();
    }

    // Method to get all food items
    public ArrayList<foodmenu> getAllFoodItems() {
        return this.foodItems;
    }

    @Override
    public String toString() {
        return "FoodmenuList{" +
                "foodItems=" + foodItems +
                '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // If there are any specific property change events to handle, you can implement them here
        // This method is optional based on your requirements
    }
}