package chapter07_class.C0714_vendingmachine_v01;

public class C071404_RestArea {
	String name;
	C071401_User user;
	C071402_VendingMachine machine;
	
	public C071404_RestArea() {
		this("만남의 광장"); // 호출
	}
	
	public C071404_RestArea(String name) {
		this.name = name;  // 맴버변수 초기화 작업
		user = new C071401_User("정국");
		welcome();
		machine = new C071402_VendingMachine(user);
	}
	
	public void welcome() {
		System.out.println("======================================");
		System.out.println("☕🍵🥤 " + name + " 휴게소에 오신 것을 환영합니다.");
		System.out.println("======================================");
	}
}
