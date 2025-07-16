package chapter07_class;

public class JAVA0701Animal02Run {
	
	public static void main(String[] args) {

		System.out.println("-- JAVA0702Animal02Run 클래스 실행 --");
		
		// 사자, 호랑이 객체 생성
		JAVA0701Animal01 lion = new JAVA0701Animal01();
		JAVA0701Animal01 tiger = new JAVA0701Animal01(); // () 안 : 생성자 매개변수
		JAVA0701Animal01 giraffe = new JAVA0701Animal01();
		JAVA0701Animal01 elephant = new JAVA0701Animal01();
		// (스택에)
		// 나이, 등등이 포함된
		
//		JAVA0701Animal01 lion = new JAVA0701Animal01("심바");
//		JAVA0701Animal01 tiger = new JAVA0701Animal01("호돌이");

		lion.name = "심바";
		lion.age = 5;
		
		tiger.name = "호돌이";
		tiger.age = 3; // 여기까지는 값만 입력이 된 상태, 출력은 시스아웃
		
		System.out.println("lion.name = " + lion.name);
		System.out.println("lion.age = " + lion.age);
		System.out.println("tiger.name = " + tiger.name);
		System.out.println("tiger.age = " + tiger.age);

		// 메소드는 항상 객체 생성 뒤에 선언
		lion.sleep();
		tiger.sleep();
		// 현재 누가 자는지 표시 안됨, 0701에서 지정 필요
		
		giraffe.name = "기린이";
		elephant.name = "코순이";
		
		System.out.println("giraffe.name = " + giraffe.name);
		System.out.println("elephant.name = " + elephant.name);
	}

}
