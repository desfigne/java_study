package c07_class.C0712_drink;

public class C071201_Menu {
	
	// Field
	int no;
	int price;
	String name;
	
	// Constructor
	public C071201_Menu() {}
	public C071201_Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;		
	}
	
	// Method
	public int getNo() { // 데이터 출력용
		return no;
	}
	
	public String getName() { // 데이터 출력용
		return name;
	}
	
	public int getPrice() { // 데이터 출력용
		return price;
	}
	
}
