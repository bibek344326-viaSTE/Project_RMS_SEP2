package client.view.staff;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sharedResources.utils.foodmenu.Foodmenu;

public class SimpleMenuViewModel {
    private final StringProperty itemNameProperty;
    private final StringProperty itemTypeProperty;

    public SimpleMenuViewModel(Foodmenu foodmenu) {
        this.itemNameProperty = new SimpleStringProperty();
        this.itemTypeProperty = new SimpleStringProperty();
    }
    public StringProperty getItemNameProperty() {
        return itemNameProperty;
    }

    public StringProperty getItemTypeProperty() {
        return itemTypeProperty;
    }
}

