package client.core;

public class ViewState {
    private int tablenumber;
    private int capacity;
    private boolean status;
    private String itemName;
    private String itemType;

    public ViewState() {
        this.tablenumber = 0;
        this.capacity = 0;
        this.status = false;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public void setItemName(String value) {
        this.itemName =  itemName;
    }

    public void setItemType(String value) {
        this.itemType= itemType;
    }
    public String getItemName() {
        return itemName;
    }
    public String getItemType() {
        return itemType;
    }
}