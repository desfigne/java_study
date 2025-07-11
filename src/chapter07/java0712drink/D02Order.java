package chapter07.java0712drink;

public class D02Order {
	
	// Field
	D01Menu orderMenu;
	
	// Constructor
	public D02Order(D01Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	public D02Order() {}
	
	// Method
	public String getName() {
		return orderMenu.name;
	}
	
	public int getTotal() {
		return orderMenu.price;
	}
	
	public void getInfo() {
		String price = String.format("%,d",  orderMenu.price);
		System.out.println(
			"=> 주문 메뉴 : " + orderMenu.name +
			", 결제 예정 금액 : " + price +"원");
	}

}
