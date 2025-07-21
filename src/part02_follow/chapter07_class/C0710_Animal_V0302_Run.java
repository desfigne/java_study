package part02_follow.chapter07_class;

public class C0710_Animal_V0302_Run {
	
	public static void main(String[] args) {

		System.out.println("-- JAVA0702Animal02Run 클래스 실행 --");
		
		// 사자, 호랑이 객체 생성
		C0701_Animal_V0101 lion = new C0701_Animal_V0101();
		C0701_Animal_V0101 tiger = new C0701_Animal_V0101(); // () 안 : 생성자 매개변수
		C0701_Animal_V0101 giraffe = new C0701_Animal_V0101();
		C0701_Animal_V0101 elephant = new C0701_Animal_V0101();
		// (스택에)
		// 나이, 등등이 포함된
		
//		JAVA0701Animal01 lion = new JAVA0701Animal01("심바");
//		JAVA0701Animal01 tiger = new JAVA0701Animal01("호돌이");

		C0708_Animal_V0201 lion2 = new C0708_Animal_V0201("심바", 5);
		C0708_Animal_V0201 tiger2 = new C0708_Animal_V0201("호돌이");
		C0708_Animal_V0201 elephant2 = new C0708_Animal_V0201();
		
		C0710_Animal_V0301 lion3 = new C0710_Animal_V0301("심바");
		lion3.info();
		
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
		
		System.out.println("--> 생성자 초기화");
		System.out.println("lion2.name = " +lion2.name);
		System.out.println("lion2.age = " +lion2.age);
		System.out.println("tiger2.name = " +tiger2.name);
		System.out.println("tiger2.age = " +tiger2.age);
		System.out.println("elephant2.name = " +elephant2.name);
	}

}
