package chapter09.java0908Drink;

public class Order {
	
	// Field
//	MenuItem orderMenu;
	Menu orderMenu;
	
	// Constructor
//	public Order(MenuItem orderMenu) {
	public Order(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	public Order() {}
	
	// Method
	public String getName() {
//		return orderMenu.name;
		return orderMenu.getName();
	}
	
	public int getTotal() {
//		return orderMenu.price;
		return orderMenu.getPrice();
	}
	
	public void getInfo() {
//		String price = String.format("%,d",  orderMenu.price);
		String price = String.format("%,d",  orderMenu.getPrice());
		System.out.println(
//			"=> 주문 메뉴 : " + orderMenu.name +
			"=> 주문 메뉴 : " + orderMenu.getName() +
			", 결제 예정 금액 : " + price +"원");
	}

}
