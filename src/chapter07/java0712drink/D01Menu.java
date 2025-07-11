package chapter07.java0712drink;

public class D01Menu {
	
	// Field
	int no;
	int price;
	String name;
	
	// Constructor
	
	public D01Menu() {}
	public D01Menu(int no, String name, int price) {
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
