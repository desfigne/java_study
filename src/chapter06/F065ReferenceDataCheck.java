package chapter06;

import java.util.Scanner;

/*
 * 기본형 데이터와 참조형 데이터의 저장구조를 정리
 */

public class F065ReferenceDataCheck {

	public static void main(String[] args) {

		// 기본형 - 스택의 value 값으로 들어감
		int a = 10;
		int b = 10;
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = "홍길똥";
		
		// call by value 형태로 값을 비교
//		System.out.println(a + " == " + b);
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2)); // 스택이 아닌 컨스턴스 풀에 동일한 스트링을 저장
		System.out.println(System.identityHashCode(str3));
		System.out.println(" a == b : " + (a == b));
		System.out.println(" str1 == str2 : " + (str1 == str2));
		
		// 참조형
		String strObj1 = new String("홍길동");
		String strObj2 = new String("홍길동");

//		System.out.println(strObj1.hashCode());
//		System.out.println(strObj2.hashCode()); // 해시코드값이라 동일하게 표시되나 실제론 다른 코드로 구분됨, JVM이 동일하다고 처리하여 동일한 코드값으로 표시되는 현상
		System.out.println(System.identityHashCode(strObj1));
		System.out.println(System.identityHashCode(strObj2));
		
		System.out.println(" strObj1 == strObj2 : " + (strObj1 == strObj2)); // Stack 주소를 비교
		System.out.println(" strObj1.equals(strObj2) : " + (strObj1.equals(strObj2))); // 주소에 담긴 내용을 비교
		
		//
		strObj1 = str1;
		System.out.println(strObj1);
		System.out.println(System.identityHashCode(strObj1));
		
		// Scanner 객체를 이용하여 문자열 입력
		Scanner scan = new Scanner(System.in);
		System.out.println("문자열 입력 > ");
		String sdata = scan.next();
		
		System.out.println(sdata);
		System.out.println(" sdata == str1 : " + (sdata == str1)); // Stack 주소를 비교
		System.out.println(" sdata.equals(str1) : " + (sdata.equals(str1))); // Heap 주소를 비교
		System.out.println(" sdata.equals(str1) : " + (str1.equals(sdata))); // Heap 주소를 비교 @@@ JVM에서 String만 자동으로 관리해줌
		
	}

}
