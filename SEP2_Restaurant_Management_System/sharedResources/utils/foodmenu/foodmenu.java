package sharedResources.utils.foodmenu;

public class foodmenu {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public foodmenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;
}
