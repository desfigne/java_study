package chapter0713.vending_machine_v01;

public class V04RestArea {
	String name;
	V01User user;
	V02VendingMachine machine;
	
	public V04RestArea() {
		this("만남의 광장");
	}
	
	public V04RestArea(String name) {
		this.name = name;
		user = new V01User("정국");
		welcome();
		machine = new V02VendingMachine();
	}
	
	public void welcome() {
		System.out.println("======================================");
		System.out.println("☕🍵🥤 " + name + " 휴게소에 오신 것을 환영합니다.");
		System.out.println("======================================");
	}
}
