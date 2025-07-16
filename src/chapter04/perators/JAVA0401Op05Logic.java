package chapter04.perators;

/*
 * 논리 연산자 : &&(AND), ||(OR), !(NOT)
 * &&, || 연산자는 앞의 식의 결과에 따라 Shortcut으로 진행됨 (Shortcut 연산자라고도 불림)
 * 하드웨어 스펙이 높아져서 Shortcut의 효과, 차이가 없음
 */

public class JAVA0401Op05Logic {

	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우에만 실행결과가 true
		System.out.println((true) && (true)); // true
		System.out.println((true) && (false)); // false
		System.out.println((false) && (false)); // false

		System.out.println((a > b) && (a == 10)); // true
		System.out.println((a > b) && (b == 10)); // false
		System.out.println((a < b) && (a == 10)); // false Shortcut으로 실행 가능
		System.out.println((a < b) && (b == 10)); // false Shortcut으로 실행 가능
		
		// OR(||) : 두 개의 항의 결과 중 하나라도 true이면 실행결과가 true
		System.out.println((a > b) || (a == 10)); // true Shortcut으로 실행 가능
		System.out.println((a > b) || (b == 10)); // true Shortcut으로 실행 가능
		System.out.println((a < b) || (a == 10)); // true
		System.out.println((a < b) || (b == 10)); // false

		// NOT(!) : 결과를 반대의 boolean 값으로 변경
		System.out.println(!(a > b) || (a == 10)); // true
		System.out.println(!(a > b) || !(a == 10)); // false
//		System.out.println(!(a); a는 int타입으로 NOT 연산자가 적용되지 않음
	}

}