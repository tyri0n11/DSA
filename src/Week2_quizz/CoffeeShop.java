package Week2_quizz;
import java.util.Arrays;

//Write a class called CoffeeShop, which has three instance variables:
//
//name : a string (basically, of the shop)
//menu : an array of items (of type MenuItem), with each item containing the item (name of the item), type (whether a food or a drink) and price.
//orders : an empty array
//and seven methods:
//
//addOrder: adds the name of the item to the end of the orders array if it exists on the menu. Otherwise, return "This item is currently unavailable!"
//fulfillOrder: if the orders array is not empty, return "The {item} is ready!". If the orders array is empty, return "All orders have been fulfilled!"
//listOrders: returns the list of orders taken, otherwise, an empty array.
//dueAmount: returns the total amount due for the orders taken.
//cheapestItem: returns the name of the cheapest item on the menu.
//drinksOnly: returns only the item names of type drink from the menu.
//foodOnly: returns only the item names of type food from the menu.
//IMPORTANT: Orders are fulfilled in a FIFO (first-in, first-out) order.
public class CoffeeShop {
    private final String name;
    private final MenuItem[] menu ;
    private String[] orders; //orders : an empty array

    public CoffeeShop(String name, MenuItem[] menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new String[0];
    }
    public String getName(){
        return this.name;
    }
    public void addOrder(String itemName){
        for(int i=0; i<orders.length; i++){
            if(menu[i].getName().equals(itemName)){
                String[] newOrders = Arrays.copyOf(orders, orders.length + 1);
                newOrders[orders.length] = itemName;
                orders = newOrders;
            }
        }
        System.out.println("Item is not in the Menu");
    }
    public String fulfillOrder(){
        if (orders.length == 0) {
            return "All orders have been fulfilled!";
        }
        String fulfilledOrder = orders[0];
        String[] newOrders = new String[orders.length - 1];
        System.arraycopy(orders, 1, newOrders, 0, newOrders.length);
        orders = newOrders;
        return "The " + fulfilledOrder + " is ready!";
    }

    public String[] listOrders(){

        return Arrays.copyOf(orders, orders.length);
    }
    public double dueAmount(){
        double amount=0;
        for (String order : orders) {
            for (MenuItem item : menu) {
                if (item.getName().equals(order)) {
                    amount += item.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

    public String cheapestItem(){
        MenuItem cheapest = menu[0];
        for (MenuItem item : menu) {
            if (item.getPrice() < cheapest.getPrice()) {
                cheapest = item;
            }
        }
        return cheapest.getName();
    }

    public boolean drinkAble(MenuItem item){
        return item.getType().equals("drink");
    }
    public String[] drinkOnly(){
        int count=0;
        for(MenuItem item : menu){
            if (drinkAble(item)){
                count++;
            }
        }
        String[] drinkable = new String[count];
        int index = 0;
        for(MenuItem item: menu){
            if (drinkAble(item)) {
                drinkable[index++] = item.getName();
            }
        }
        return drinkable;
    }
    public boolean eatAble(MenuItem item){
        return item.getType().equals("food");
    }
    public String[] foodOnly(){
        int count=0;
        for(MenuItem item : menu){
            if (eatAble(item)){
                count++;
            }
        }
        String[] eatable = new String[count];
        int index = 0;
        for(MenuItem item: menu){
            if (eatAble(item)) {
                eatable[index++] = item.getName();
            }
        }
        return eatable;
    }

    public static void main(String[] args) {
        // Create menu items
        MenuItem[] menu = {
                new MenuItem("Coffee", "drink", 2.50),
                new MenuItem("Tea", "drink", 2.00),
                new MenuItem("Sandwich", "food", 5.00)
        };

        // Create a coffee shop
        CoffeeShop shop = new CoffeeShop("The Coffee Corner", menu);

        // Test addOrder method
        shop.addOrder("Coffee");
        shop.addOrder("Sandwich");
        shop.addOrder("Juice"); // Should print "Item is not in the Menu"

        // Test fulfillOrder method
        System.out.println(shop.fulfillOrder()); // Output: The Coffee is ready!

        // Test listOrders method
        String[] orders = shop.listOrders();
        System.out.println("Current orders: " + Arrays.toString(orders)); // Output: Current orders: [Sandwich]

        // Test dueAmount method
        System.out.println("Total due: " + shop.dueAmount()); // Output: Total due: 5.0

        // Test cheapestItem method
        System.out.println("Cheapest item: " + shop.cheapestItem()); // Output: Cheapest item: Tea

        // Test drinksOnly method
        String[] drinks = shop.drinkOnly();
        System.out.println("Drinks: " + Arrays.toString(drinks)); // Output: Drinks: [Coffee, Tea]

        // Test foodOnly method
        String[] food = shop.foodOnly();
        System.out.println("Food: " + Arrays.toString(food)); // Output: Food: [Sandwich]
    }

}
