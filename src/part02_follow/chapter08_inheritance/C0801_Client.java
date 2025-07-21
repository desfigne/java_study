package part02_follow.chapter08_inheritance;

// abstract 메소드를 하나라도 가지고 있으면 그 클래스는 abstract 클래스가 된다.
// abstract(추상) 클래스는 객체 생성이 불가능하다.
abstract public class C0801_Client {
	
//	String name;
//	int age;
	
	public static String name;
	public static int age;
	
//	public JAVA0801Client() {
//		this("홍길동", 10);
////		System.out.println("Client 기본 생성자 호출");
//	}
//	
//	public JAVA0801Client(String name) {
//		this(name, 0);
//	}
//	
//	public JAVA0801Client(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
	
	// Method
//	public void printInfo() { // 부모가 가진 printInfo() 메소드를 강제적으로 상속함, 아래에 내용이 채워지면 동일하지 않음
//		System.out.println("고객(Client)정보 --> " + name + ", " + age);
//	}
	
	// 오버라이드되는 메소드는 body 없이 이름만 선언됨
	// body가 없는 메소드를 추상(abstract) 메소드라고 명명함
//	public void printInfo();
//	public void printInfo(); // 추상 메소드가 동작하려면 최상위 클래스에도 abstract가 붙어야 함
//	public void printInfo() {
//		System.out.print("고객(Client)정보 --> ");
//		System.out.print(name + ",");
//		System.out.print(age + "\n");
//	}
	
	// 내용이 없더라도 상속받는 자식 클래스에 오버라이딩 처리 해야 함
	abstract public void printInfo();
	abstract public void register();
	abstract public void payment();
	
}
