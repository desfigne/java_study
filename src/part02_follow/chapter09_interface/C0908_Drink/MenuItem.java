package part02_follow.chapter09_interface.C0908_Drink;

public class MenuItem implements Menu {
	
	// Field
	int no;
	int price;
	String name;
	
	// Constructor
	public MenuItem() {}
	public MenuItem(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
//	// Method
//	public int getNo() { // 데이터 출력용
//		return no;
//	}
//	
//	public String getName() { // 데이터 출력용
//		return name;
//	}
//	
//	public int getPrice() { // 데이터 출력용
//		return price;
//	}
	
	@Override
	public int getNo() { return no; }
	
	@Override
	public String getName() { return name; }
	
	@Override
	public int getPrice() { return price; }
	
	
	
}
