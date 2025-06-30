package chapter03;

/*
 * 제어문자 실습
 */

public class JAVA0305Escape {

	public static void main(String[] args) {
		String greet = "안녕하세요~\n반갑습니다. \t\t홍길동입니다.";
		String name = "\'홍길동\'";
		String name2 = "\"홍길동\"";
		
		System.out.println(greet);
		System.out.println(name);
		System.out.println(name2);

	}

}
