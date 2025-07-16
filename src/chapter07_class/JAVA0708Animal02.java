package chapter07_class;

public class JAVA0708Animal02 {
	// Field : 전역변수
	String name;
	int age;
	String date;
	
	// Constructor : 생성자는 오버로딩이 가능함!!
	public JAVA0708Animal02() { // 기본 생성자
		System.out.println("객체를 생성한다.");
	}
	public JAVA0708Animal02(String name) { // field의 name만 초기화
		this.name = name; // 앞 부분은 전역 변수
		System.out.println("객체를 생성한다.");
	}
	public JAVA0708Animal02(String name, int age) { // field의 name, age 초기화
		this.name = name; // 앞 부분은 전역 변수
		this.age = age; // 앞 부분은 전역 변수
		System.out.println("객체를 생성한다.");
	}
	public void sleep() {
		System.out.println(name + " -> 잠을 잔다.");
	}
	
}
