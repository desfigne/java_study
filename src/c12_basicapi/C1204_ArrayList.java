package c12_basicapi;

import java.util.ArrayList;
import java.util.Scanner;

public class C1204_ArrayList {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("홍길동");
//		list2.add(123); // 스트링 타입이 아니여서 들어가지 않음
		list2.add(String.valueOf(123));
		list2.set(0, "이순신"); // 업데이트
		list2.add(1, "김유신"); // 중간 추가
		list2.remove(2);      // 삭제
		
		for(String str :list2) {
			System.out.println(str);
		}
		
//		System.out.println(list.length); // 배열로 착각하지 않도록 랭스를 사용하지 않고 사이즈 사용
		System.out.println(list.size()); // 채워진 공간수만큼 콘솔에 수가 표시됨
		list.add(100); // < 이렇게 사용할 수 있지만 권장하는 방식은 아님
		list.add(new String("홍길동"));
		list.add(123.456);
		list.add(new Scanner(System.in)); // >
		System.out.println(list.size()); // 채워진 공간수만큼 콘솔에 수가 표시됨
//		System.out.println(list[0]); // 인덱스는 JVM 내부에서 관리하기에 접근이 안됨
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(3));
		
	}

}
