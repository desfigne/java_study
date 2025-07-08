package chapter07;

/*
 * 생성자 오버로딩, this() 메소드
 */
public class JAVA0710Animal03 {
	
	// Field
	int age;
	String name;
	String addr;
	
	// Constructor
	public JAVA0710Animal03() {
		this("홍길동", 5, "강남구");
	}
	
	public JAVA0710Animal03(String name) {
		this(name, 5, "강남구");

	}
	
	public JAVA0710Animal03(int age) {
		this("홍길동", age, "강남구");
	}
	
	public JAVA0710Animal03(String name, int age) {
		this(name, age, "강남구");
	}
	
	public JAVA0710Animal03(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	// Method
	public void info() {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("addr = " + addr);
	}

}
