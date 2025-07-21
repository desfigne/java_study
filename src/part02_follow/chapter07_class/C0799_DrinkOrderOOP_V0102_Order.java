package part02_follow.chapter07_class;

public class C0799_DrinkOrderOOP_V0102_Order {
    private C0799_DrinkOrderOOP_V0101_Menu menu;
    private int quantity;

    public C0799_DrinkOrderOOP_V0102_Order(C0799_DrinkOrderOOP_V0101_Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return menu.getPrice() * quantity;
    }

    public C0799_DrinkOrderOOP_V0101_Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
