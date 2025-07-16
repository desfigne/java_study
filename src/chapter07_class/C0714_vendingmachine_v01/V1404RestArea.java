package chapter07_class.C0714_vendingmachine_v01;

public class V1404RestArea {
	String name;
	V1401User user;
	V1402VendingMachine machine;
	
	public V1404RestArea() {
		this("만남의 광장"); // 호출
	}
	
	public V1404RestArea(String name) {
		this.name = name;  // 맴버변수 초기화 작업
		user = new V1401User("정국");
		welcome();
		machine = new V1402VendingMachine(user);
	}
	
	public void welcome() {
		System.out.println("======================================");
		System.out.println("☕🍵🥤 " + name + " 휴게소에 오신 것을 환영합니다.");
		System.out.println("======================================");
	}
}
