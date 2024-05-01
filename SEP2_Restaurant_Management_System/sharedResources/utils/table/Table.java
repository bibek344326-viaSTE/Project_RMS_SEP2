package sharedResources.utils.table;

public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private int capacity; // New variable to track the maximum capacity of the table

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isOccupied = false;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public void occupyTable() {
        if (!isOccupied) {
            isOccupied = true;
            System.out.println("Table " + tableNumber + " has been occupied.");
        } else {
            System.out.println("Table " + tableNumber + " is already occupied.");
        }
    }

    public void vacateTable() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Table " + tableNumber + " has been vacated.");
        } else {
            System.out.println("Table " + tableNumber + " is already vacant.");
        }
    }
}
