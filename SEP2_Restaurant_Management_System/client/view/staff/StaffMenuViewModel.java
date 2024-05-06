package client.view.staff;

import client.core.ModelFactory;
import client.core.ViewState;
import client.model.foodmenu.FoodmenuModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaffMenuViewModel  {
    private ObservableList<SimpleMenuViewModel> menuList;
    private FoodmenuModel foodmenuModel;
    private ObjectProperty<SimpleMenuViewModel> selectedMenuProperty;
    private StringProperty errorLabel;
    private ViewState viewState;

    public StringProperty getErrorProperty() {
        return errorLabel;
    }


    public StaffMenuViewModel(ModelFactory modelFactory, ViewState viewState) {
        this.foodmenuModel = modelFactory.getFoodMenuModel();
        this.menuList = FXCollections.observableArrayList();
        this.selectedMenuProperty = new SimpleObjectProperty<>();
        this.errorLabel = new SimpleStringProperty();
        this.viewState = viewState;
    }

    public ObservableList<SimpleMenuViewModel> getMenuList() {
        return menuList;
    }

    public void setSelected(SimpleMenuViewModel menu){
        if (menu == null){
            viewState.setItemName(selectedMenuProperty.get().getItemNameProperty().getValue());
            viewState.setItemType(selectedMenuProperty.get().getItemTypeProperty().getValue());
        }
        else{
            this.selectedMenuProperty.set(menu);
            viewState.setItemName(selectedMenuProperty.get().getItemNameProperty().getValue());
            viewState.setItemType(selectedMenuProperty.get().getItemTypeProperty().getValue());
        }
    }

    public void deselect(){
        setSelected(null);
//    viewState.setTitle(null);
//    viewState.setState(null);
//    viewState.setRemove(false);
    }

    public void updateTableList(){
        menuList.clear();
        for(int i = 0; i < foodmenuModel.getAllFoodItems().size(); i++){
            menuList.add(new SimpleMenuViewModel(foodmenuModel.getAllFoodItems().get(i)));
        }
    }

    public void addNewMenuItems() {
        String nextMenu = String.valueOf(menuList.size() + 1);
        String capacity = "6"; // Specify the data type as String
        foodmenuModel.addFoodItem(nextMenu, capacity);
        updateTableList();
    }


    public void editMenuItems() {
        SimpleMenuViewModel selectedMenu = selectedMenuProperty.get();
        if (selectedMenu != null) {
            int menuIndex = menuList.indexOf(selectedMenu);
            if (menuIndex != -1) {
                String newItemName = "New Item Name";
                String newItemType = "New Item Type";

                selectedMenu.getItemNameProperty().set(newItemName);
                selectedMenu.getItemTypeProperty().set(newItemType);

                // Update the menuList by removing the old menu item and adding the updated menu item
                menuList.remove(menuIndex);
                menuList.add(menuIndex, selectedMenu);

                errorLabel.set("Menu item updated successfully.");
            } else {
                errorLabel.set("Selected menu item not found in the list.");
            }
        } else {
            errorLabel.set("Please select a menu item to edit.");
        }
    }

    public void deleteMenuItems() {
        SimpleMenuViewModel selectedMenu = selectedMenuProperty.get();
        if (selectedMenu != null) {
            foodmenuModel.deleteFoodItem(selectedMenu.getItemNameProperty().get()); // Delete the selected Menu
            updateTableList();
        }
    }


}





