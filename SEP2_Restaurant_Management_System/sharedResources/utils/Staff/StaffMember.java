package sharedResources.utils.Staff;


import client.model.table.TableList;

import java.util.ArrayList;

public class StaffMember extends Staff {
    private TableList tableList;

    public StaffMember(String name, int id) {
        super(name, id);
        this.name = name;
        this.tableList = new TableList();
    }

    public void addTable(int tableNumber, int capacity) {
        tableList.createTable(tableNumber, capacity);
    }

    public void removeTable(int tableNumber) {
        tableList.deleteTable(tableNumber);
    }


    public void occupyTable(int tableNumber) {
        tableList.updateTable(tableNumber, true);
    }


    public void vacateTable(int tableNumber) {
        tableList.updateTable(tableNumber, false);
    }
    }