package chapter07_class.C0712_drink;

public class C071202_Order {
	
	// Field
	C071201_Menu orderMenu;
	
	// Constructor
	public C071202_Order(C071201_Menu orderMenu) {
		this.orderMenu = orderMenu;
	}
	
	public C071202_Order() {}
	
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
