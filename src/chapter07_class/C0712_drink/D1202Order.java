package chapter07_class.C0712_drink;

public class D1202Order {
	
	// Field
	D1201Menu orderMenu;
	
	// Constructor
	public D1202Order(D1201Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	public D1202Order() {}
	
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
