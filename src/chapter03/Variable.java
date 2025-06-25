package chapter03;

// import java.lang.String; lang 패키지는 자주 사용하는 명령어를 모와두어 생략 가능

public class Variable {
	public static void main(String[] args) {
		// 기본 자료형 변수 정의
		int age = 10;
		double aged = 10.0;
		boolean flag = true; //true(1), false(0)
		char name = '홍';
		char name2 = '길';
		char name3 = '동';
		String sname = "홍길동";

		// 참조 자료형 변수 정의
		String sname2 = new String("홍길동");
		
		// ** String 클래스는 기본형과 참조형으로 모두 사용 가능!!
		String sname3 = ("홍길동 입니다");
		
		// 출력
		System.out.println(age);
		System.out.println(aged);
		System.out.println(flag);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name2);
		System.out.print(name3);
		System.out.println(sname);
		System.out.println(sname2);
	}
}
