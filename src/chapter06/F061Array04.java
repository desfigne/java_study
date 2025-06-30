package chapter06;

import java.util.Scanner;

public class F061Array04 {

	public static void main(String[] args) {
		
		// 배열 객체 생성 후 크기 확인 : 기본형 데이터를 저장하는 객체 생성
		int[] numberList = new int[5];
		String[] nameList = { "홍길동", "홍길순", "김유신" };
		boolean[] flagList = new boolean[2];
		
		// 배열 객체 생성 후 크기 확인 : 참조 데이터를 저장하는 객체 생성
//		Scanner scan = new Scanner(System.in);
		Scanner[] scanList = new Scanner[3]; // Scanner 클래스의 객체를 3개 저장
		
		// scanList 0번지에 Scanner 객체 생성 후 주소 저장
		scanList[0] = new Scanner(System.in);
		scanList[1] = new Scanner(System.in);
		scanList[2] = new Scanner(System.in);

		System.out.println(numberList.length);
		System.out.println(nameList.length);
		System.out.println(flagList.length);
		System.out.println(scanList.length);
		System.out.println(scanList[0]);
		System.out.println(scanList[1]);
		System.out.println(scanList[2]);
		
		// JDK > 런타임 영역 > 메모리
		// 1. Stack > scanList []라는 빈칸이 생성됨
		// 2. Heap > scanList []라는 담는 영역(1칸)에 들어갈 수 있는 내가 지정한 개수에 맞게 빈칸이 생성됨
		// 3. Heap > 힙의 지정된 개수에 맞게 scanner(system.in)라는 개체를 순서대로 넣음
		
		// scanList[0] = scanList[2}; <- 힙 영역의 0번지 칸에 2번지의 내용을 넣는다.
		// 메모리에 값이 저장될 경우 call by value *객체 생성 없이 값이 바로 변경됨
		// 메모리에 주소값이 저장될 경우 call by reference
		// 더이상 참조되지 않는 주소값은 연결이 끊어져 가비지 컬렉터 대상이 됨

		System.out.println(scanList[0].hashCode());
		System.out.println(scanList[1].hashCode());
		System.out.println(scanList[2].hashCode()); // 결과값을 출력했을때 다른 값이 나와 별개의 주소가 생성됐다는걸 확인 가능
		
		
		// Call by reference
		scanList[0] = scanList[2];
		
		System.out.println(scanList[0].hashCode());
		System.out.println(scanList[1].hashCode());
		System.out.println(scanList[2].hashCode()); // 결과값을 출력했을때 같은 값이 나와 동일 주소가 반영됐다는걸 확인 가능
		
		int[] nList = new int[3];
		nList[0] = 10;
		nList[1] = 20;
		nList[2] = 30;
		
		nList[0] = nList[2];
		
//		System.out.println(nList[0].hashCode()); // 해쉬코드는 주소값이므로 에러
		System.out.println(nList[0]);
		System.out.println(nList[1]);
		System.out.println(nList[2]);
		
	}

}
