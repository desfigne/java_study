package chapter07;

import java.util.Calendar;

import chapter07.java0713commons.JAVA0715Animal;

public class JAVA0715Animal04AccessModifier02Test {

	public static void main(String[] args) {
		
		// calendar 객체 생성
//		Calendar c = new Calendar(); // 상속관계가 없으므로 객체 생성 불가
		Calendar c = Calendar.getInstance(); // 생성된 객체의 인스턴스주소를 가져옴, singleton(싱글톤)
		System.out.println(c.getTime());
		
		// 1. static 변수, static 메소드 호출 방법 1 - 클래스명.이름
		JAVA0715Animal04AccessModifier.sname = "스택틱";
		JAVA0715Animal04AccessModifier.sage = 10;
		JAVA0715Animal04AccessModifier.getInfo3();

		JAVA0715Animal04AccessModifier aam =  new JAVA0715Animal04AccessModifier("호순이", 5);
		JAVA0715Animal comDog =  new JAVA0715Animal();

		// 1. static 변수, static 메소드 호출 방법 2 - 객체명.이름
		// < 잘 사용하지 않는 방법
		aam.sname = "스택틱2";
		aam.sage = 12;
		aam.getInfo3();
		// >
		
		// final 변수 테스트
//		aam.fname = "홍길순"; // 에러 뜨는 이유 : final 키워드 변수는 외부에서 값을 변경 X
//		aam.fage = 2;
		
		// 상수 호출
		int start = JAVA0715Animal04AccessModifier.START;
		int con = JAVA0715Animal04AccessModifier.CONTINUE;
		int END = JAVA0715Animal04AccessModifier.END;
		
		comDog.setName("호순이");
		comDog.setAge(10);
		
//		comDog.name = "예삐"; // 패키지가 다르므로 접근 불가 : default(package), 접근제어자 퍼블릭 선언 후에 정상 접근
//		comDog.age = 5;      // 패키지가 다르므로 접근 불가 : default(package), 접근제어자 퍼블릭 선언 후에 정상 접근
		
		aam.name = "심바";    // 접근제어자 프라이빗 선언 후 접근 불가
		aam.age = 5;         // 접근제어자 프라이빗 선언 후 접근 불가
		
//		aam.pname = "호순이";  // 클래스가 다르므로 접근 불가 : private
//		aam.page = 5;        // 클래스가 다르므로 접근 불가 : private

		System.out.println("name : " + aam.name);
		System.out.println("age : " + aam.age);
		System.out.println("name : " + aam.getPname());
		System.out.println("age : " + aam.getPage());
		System.out.println("name : " + comDog.getName());
		System.out.println("age : " + comDog.getAge());

	}

}
