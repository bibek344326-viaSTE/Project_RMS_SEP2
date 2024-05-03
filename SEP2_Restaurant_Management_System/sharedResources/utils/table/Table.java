package sharedResources.utils.table;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Table implements UnnamedPropertyChangeSubject {

    private int tableNumber;
    private boolean isOccupied;
    private int capacity;
    private PropertyChangeSupport property;

    public int getTableNumber() {return tableNumber;}
    public void setTableNumber(int tableNumber) {this.tableNumber = tableNumber;}
    public boolean isOccupied() {return isOccupied;}
    public void setOccupied(boolean occupied) {isOccupied = occupied;}
    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
        this.property= new PropertyChangeSupport(this);
    }

    public void occupyTable() {
        if (!isOccupied) {
            boolean oldOccupied = isOccupied;
            isOccupied = true;
            System.out.println("Table " + tableNumber + " has been occupied.");
            property.firePropertyChange("isOccupied", oldOccupied, isOccupied);
        } else {
            System.out.println("Table " + tableNumber + " is already occupied.");
        }
    }

    public void vacateTable() {
        if (isOccupied) {
            boolean oldOccupied = isOccupied;
            isOccupied = false;
            System.out.println("Table " + tableNumber + " has been vacated.");
            property.firePropertyChange("isOccupied", oldOccupied, isOccupied);
        } else {
            System.out.println("Table " + tableNumber + " is already vacant.");
        }
    }
    @Override
    public String toString() {
        return "Table{" +
                "tableNumber=" + tableNumber +
                ", isOccupied=" + isOccupied +
                ", capacity=" + capacity +
                '}';
    }

    @Override public void addListener(PropertyChangeListener listener)
    {
        property.addPropertyChangeListener(listener);
    }

    @Override public void removeListener(PropertyChangeListener listener)
    {
        property.removePropertyChangeListener(listener);
    }
}