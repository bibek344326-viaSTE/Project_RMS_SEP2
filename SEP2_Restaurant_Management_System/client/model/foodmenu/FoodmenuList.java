package client.model.foodmenu;

import sharedResources.utils.foodmenu.Foodmenu;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class FoodmenuList implements PropertyChangeListener {
    private ArrayList<Foodmenu> foodItems;

    public FoodmenuList() {
        foodItems = new ArrayList<>();
    }

    // Method to add a new food item
    public void addFoodItem(String name, String type) {
        Foodmenu newFoodItem = new Foodmenu(name, type);
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
    public void editFoodItem( String name, String type) {
        for (Foodmenu foodItem : foodItems) {
            if (foodItem.getName().equals(name)) {
                foodItem.setName(name);
                foodItem.setType(type);
                break;
            }
        }
    }

    // Method to get the number of food items
    public int getNumberOfFoodItems() {
        return foodItems.size();
    }

    // Method to get all food items
    public ArrayList<Foodmenu> getAllFoodItems() {
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