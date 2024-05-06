package client.view.staff;

import javafx.beans.property.*;
import sharedResources.utils.table.Table;


public class SimpleTableViewModel {
    private final IntegerProperty tableNumberProperty;
    private final IntegerProperty capacityProperty;
    private final BooleanProperty statusProperty;

    public SimpleTableViewModel(Table table) {
        this.tableNumberProperty = new SimpleIntegerProperty(table.getTableNumber());
        this.capacityProperty = new SimpleIntegerProperty(table.getCapacity());
        this.statusProperty = new SimpleBooleanProperty(table.isOccupied());


    }

    public IntegerProperty getTableNumberProperty() {
        return tableNumberProperty;
    }

    public IntegerProperty getCapacityProperty() {
        return capacityProperty;
    }

    public BooleanProperty getStatusProperty() {
        return statusProperty;
    }

}