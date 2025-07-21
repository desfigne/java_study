package chapter08_inheritance;

public class C0802_Person extends C0801_Client{
	
//	String name;
//	String address;
//	String phone;
//	int age;
//	
//	public JAVA0802Person() {
//		this("이순신", "강남구", "010-1234-1234", 20);
//		System.out.println("Person 기본 생성자 호출");
//	}
//	
//	public JAVA0802Person(String name, String address, String phone, int age) {
////		this.name = name;
////		this.address = address;
////		this.phone = phone;
////		this.age = age;
//		
//		// name, age 필드는 부모클래스에서 사용할 경우 ( 부모 클래스의 생성자 호출 메소드 super() )
//		super(name, age);
//		
////		this.name = name;
//		this.address = address;
//		this.phone = phone;
////		this.age = age;
//	}
	
	String name;
	String address;
	String phone;
	int age;
	
	public C0802_Person() {
		this("이순신", "강남구", "010-1234-1234", 20);
//		System.out.println("Person 기본 생성자 호출");
	}
	
	public C0802_Person(String name, String address, String phone, int age) {
		
		// name, age 필드는 부모클래스에서 사용할 경우 ( 부모 클래스의 생성자 호출 메소드 super() )
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		
	}
	
//	public void personRegister() {
//		System.out.println("접수한다.");
//	}
	
	@Override
	public void register() {
		System.out.println(name + " 고객이 접수를 한다.");
	}
	
	@Override
	public void payment() {}
	
	@Override // 붙인다고 기능적으로 바뀌는건 아니고 표식으로 가독성 높임
	public void printInfo() { // 부모가 가진 메소드를 똑같은 모습으로 가져옴 - 오버라이딩(Overriding)
		System.out.print("고객(Person)정보 --> ");
		System.out.print(name + ", ");
		System.out.print(age + ", ");
		System.out.print(address + ", ");
		System.out.print(phone + "\n");
	} // 부모 클래스에서 자식 클래스로 이동 처리

}
