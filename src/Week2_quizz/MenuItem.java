package Week2_quizz;

public class MenuItem {
    String itemName;
    String itemType;

    double price;

    public MenuItem(String itemName, String itemType, double price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
    }
    public String getName() {
        return itemName;
    }
    public String getType() {
        return itemType;
    }

    public double getPrice() {
        return price;
    }
}
