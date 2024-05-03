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
            int price = random.nextInt(20) + 5; // Random price between 5 and 24
            foodmenuList.addFoodItem(name, price);
        }
    }

    @Override
    public void addFoodItem(String name, int price) {
        foodmenuList.addFoodItem(name, price);

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