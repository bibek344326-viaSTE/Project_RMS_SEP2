package client.core;

public class ViewState {
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

    private int tablenumber;
    private int capacity;
    private boolean status;

    public ViewState() {
        this.tablenumber = 0;
        this.capacity = 0;
        this.status = false;
    }
}