package sharedResources.utils.foodmenu;

public class foodmenu {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public foodmenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private int price;
}
