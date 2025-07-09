package chapter07.JAVA0714vending_machine_v02;

public class RestArea {
	// Field
	
	String name;
	
	
	
	
	
	// constructor
	
	
	
	
	
	// Method
	
	public RestArea() {
		this("미입력시");
	}
	
	public RestArea(String name) {
		this.name = name;
		welcome();
	}
	
	public void welcome() {
		System.out.println("==============================================");
		System.out.println("\t" + name + "자판기에 오신 것을 한영합니다.");
		System.out.println("==============================================");
	}
	
}
