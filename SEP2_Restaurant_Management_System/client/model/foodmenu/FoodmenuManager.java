package client.model.foodmenu;

import sharedResources.utils.foodmenu.foodmenu;
import java.util.ArrayList;
import java.util.Random;

public class FoodmenuManager implements FoodmenuModel {
    private final FoodmenuList foodmenuList;

    public FoodmenuManager() {
        this.foodmenuList = new FoodmenuList();
        createDummyData();
    }

    private void createDummyData() {
        Random random = new Random();
        String[] dishNames = {"Pasta", "Pizza", "Burger", "Salad", "Sushi", "Steak", "Soup", "Sandwich", "Taco", "Curry"};
        for (int i = 0; i < 10; i++) {
            String name = dishNames[random.nextInt(dishNames.length)];
            String description = "Description for " + name; // Example description
            foodmenuList.addFoodItem(name, description);
        }
    }

    @Override
    public void addFoodItem(String name, String description) {
        foodmenuList.addFoodItem(name, description);
    }

    @Override
    public void deleteFoodItem(String name) {
        foodmenuList.deleteFoodItem(name);
    }

    @Override
    public int getNumberOfFoodItems() {
        return foodmenuList.getNumberOfFoodItems();
    }

    @Override
    public ArrayList<foodmenu> getAllFoodItems() {
        return foodmenuList.getAllFoodItems();
    }
}