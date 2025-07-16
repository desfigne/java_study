package chapter08_inheritance;

public class JAVA0804Inheritance {

	public static void main(String[] args) {

//		JAVA0801Client c1 = new JAVA0801Client(); // abstract 클래스이므로 객체 생성 불가
//		JAVA0802Person p1 = new JAVA0802Person();
		JAVA0802Person lee = new JAVA0802Person();
//		JAVA0803Animal a1 = new JAVA0803Animal(); // ()은 기본 생성자이므로 각 자바 파일에 기본 생성자를 생성해야 함
//		JAVA0802Person p2 = new JAVA0802Person("김유신", "종로구", "010-5678-5678", 12);
		JAVA0802Person kim = new JAVA0802Person("김유신", "종로구", "010-5678-5678", 12);
		
//		JAVA0803Animal dog = new JAVA0803Animal("명수", 5, null);
//		JAVA0803Animal cat = new JAVA0803Animal("야옹이", 6, null);
		
//		JAVA0803Animal dog = new JAVA0803Animal("명수", 5, p1);
//		JAVA0803Animal cat = new JAVA0803Animal("야옹이", 6, p2);
		JAVA0803Animal dog = new JAVA0803Animal("명수", 5, lee);
		JAVA0803Animal cat = new JAVA0803Animal("야옹이", 6, kim);
		
//		c1.name = "홍길동";
//		p1.name = "홍길동"; // 부모인 Client의 name 변수 사용을 어떻게 하는가?
////		p1.JAVA0801Client.name = "홍길동"; // 부모인 Client의 name 변수는 사용 불가, 자식의 필드가 없으면 부모의 주소값의 필드에 넣는다. 부모의 필드가 없을때 그때 에러가 뜬다.
//		a1.name = "예삐";
		
//		System.out.println("c1.name ==> " + c1.name);
//		System.out.println("p1.name ==> " + p1.name);
//		System.out.println("a1.name ==> " + a1.name);
//		System.out.println("p2.name ==> " + p2.name);
		
//		c1.printInfo(); // 클라이언트
//		p1.printInfo(); // 퍼슨 (부모의 것을 호출할 수 없음)
//		p2.printInfo(); // 퍼슨 (부모의 것을 호출할 수 없음)
		lee.printInfo(); // 퍼슨 (부모의 것을 호출할 수 없음)
		kim.printInfo(); // 퍼슨 (부모의 것을 호출할 수 없음)
//		a1.printInfo();
		dog.printInfo(); // 클라이언트
		cat.printInfo(); // 클라이언트
		
		lee.register();
		kim.register();
		dog.register();
		
		dog.sound();
		cat.sound();
		
	}

}
