package chapter07_class.C0714_vendingmachine_v01;

public class V03Menu {
	
	int no;
	int price;
	String name;
	
	public V03Menu() {}
	public V03Menu(int no, String name, int price) {
		this.no = no;
		this.name = name;
		this.price = price;
	}
	
	public int getNo() { return no; }
	public String getName() { return name; }
	public int getPrice() { return price; }
}
