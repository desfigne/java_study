package chapter07;

public class JAVA0799DrinkOrderOOP02Order {
    private JAVA0799DrinkOrderOOP01Menu menu;
    private int quantity;

    public JAVA0799DrinkOrderOOP02Order(JAVA0799DrinkOrderOOP01Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    public JAVA0799DrinkOrderOOP01Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
