package part02_follow.chapter07_class;

public class C0701_Animal_V0101 {
	// Field
	
	
	// Constructor
	
	
	// Method
	
	
	// 위 순서대로 미리 정하고 채워나가기

	
	
	// Field : 전역변수
	String name; // 재사용성을 위해 = "홍길동" 지양
	int age;
	String date;
	
	// Constructor
	public C0701_Animal_V0101() { // 기본 생성자
		// () : 기능을 가지고 있는 부분, 괄호 안주면 클래스로 취급됨
		// 생성자 호출시 실행되는 내용 => new Animal() 코드 실행 시 실행됨
		System.out.println(name + "객체를 생성한다.");
	}
//	public JAVA0701Animal01(String name) { // 기본 생성자
//		// () : 기능을 가지고 있는 부분, 괄호 안주면 클래스로 취급됨
//		// 생성자 호출시 실행되는 내용 => new Animal() 코드 실행 시 실행됨
//		this.name = name;
//		System.out.println(name + "객체를 생성한다.");
//	}
	
	// Method
//	public [반환타입=리턴타입] sleep() {
	public void sleep() {
//		System.out.println("잠을 잔다."); // 클래스가 하나 생성됨
		System.out.println(name + " -> 잠을 잔다.");
	}
	
	public static void main(String[] args) {
		C0701_Animal_V0101 giraffe = new C0701_Animal_V0101();
		C0701_Animal_V0101 elephant = new C0701_Animal_V0101();
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = " + giraffe.name);
		System.out.println("elephant.name = " + elephant.name);
	}
	
	// 위 순서대로 미리 정하고 채워나가기
}
