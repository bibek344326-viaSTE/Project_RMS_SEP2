package client.model.foodmenu;

import client.mediator.foodmenu.FoodMenuClient;
import sharedResources.utils.foodmenu.Foodmenu;

import java.util.ArrayList;
import java.util.Random;

public class FoodmenuManager implements FoodmenuModel {
    private final FoodmenuList foodmenuList;


    public FoodmenuManager(FoodMenuClient foodMenuClient) {
        this.foodmenuList = new FoodmenuList();

        createDummyData();
    }

    private void createDummyData() {
        Random random = new Random();
        String[] dishNames = {"Pasta", "Pizza", "Burger", "Salad", "Sushi", "Steak", "Soup", "Sandwich", "Taco", "Curry", "coca cola"};
        String[] dishTypes = {"Main Course", "Appetizer", "Dessert", "Beverage", "Side Dish"}; // Example types, you can adjust this array as needed

        for (int i = 0; i < 10; i++) {
            String name = dishNames[random.nextInt(dishNames.length)];
            String type = dishTypes[random.nextInt(dishTypes.length)]; // Random type selection
            foodmenuList.addFoodItem(name, type);
        }
    }


    @Override
    public void addFoodItem(String name, String type) {
        foodmenuList.addFoodItem(name, type);
    }

    @Override
    public void editFoodItem(String name, String type) {
        foodmenuList.editFoodItem(name, type);
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
    public ArrayList<Foodmenu> getAllFoodItems() {
        return foodmenuList.getAllFoodItems();
    }


}