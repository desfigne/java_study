package chapter13_collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * List 인터페이스
 */

public class C1301_InterfaceList {

	public static void main(String[] args) {

		// 일반적으로 제너릭<>을 통해 데이터타입을 정의한 후 사용함, 제너릭을 명시하지 않으면 모든 타입이 들어감
//		List<int> list1 = new ArrayList<int>(); // 클래스 타입으로 들어가야 하므로 Integer로 들어가야함
//		List list2 = new LinkedList();
//		List list3 = new Vector();
		List<Integer> list1 = new ArrayList<Integer>(); // 클래스 타입으로 들어가야 하므로 Integer로 들어가야함
		List<String> list2 = new LinkedList<String>();
		List<Double> list3 = new Vector<Double>();
		
//		list1.add(100);
//		int n = 100;
//		list1.add(n); // JVM이 자동으로 int를 껍데기를 씌워 인티저 타입으로 집어넣음
		
		// 1. 데이터 저장 : C(Create)
		list1.add(100);			list1.add(200);
		list2.add("100");		list2.add("홍길동");
		list3.add(1.23);		list3.add(3.456);
		
		// 2. 데이터 출력 : R(Read)
		
		// 일반 for문 > 메소드 타입이 아닌 제어문으로 의존적이지 않음
		for(int i=0; i<list1.size(); i++) { // size는 전체 값이 아닌 들어가있는 만큼 가져옴
			System.out.println(list1.get(i));
		}
		
		// 향상된 for문 > 메소드 타입이 아닌 제어문으로 의존적이지 않음
		for(String str : list2) {
			System.out.println(str);
		}
		
		String[] slist = new String[5];
//		slist.forEach(null); // 형식적인, 구조적인 형태로는 사용이 안됨, 자바스크립트에서는 iterable이 자동으로 적용되서 가능한 차이가 있음
		
//		list3.forEach(null); //  > 메소드 타입으로 의존적임

		// forEach의 매개변수는 람다식 메소드 호출 방식을 갖는다.
		// () -> {}
		list3.forEach((dnum) -> {                                 // < 자바스크립트에서 자주 쓰이는 방식
			System.out.println(dnum);
		});

		list3.forEach(dnum -> System.out.println(dnum));
		
//		list3.forEach(클래스타입::메소드명); // 자바 8버전 이상부터 사용 가능
		list3.forEach(System.out::println);                       // >
		
		// 3. 데이터 업데이트 : U(Update)
		list1.set(0, 1000);
		list2.set(0, "이순신");
		list3.set(0, 999.987);
		
		list1.forEach(System.out::print);
		list2.forEach(System.out::print);
		list3.forEach(System.out::println);
		
		// 4. 데이터 삭제 : D(Delete)
		list1.remove(0);
		list2.remove(0);
		list3.remove(0);
		
		list1.forEach(System.out::print);
		list2.forEach(System.out::print);
		list3.forEach(System.out::println);
		// **데이터 삭제시 인덱스 중복으로 인한 내부 에러 발생함
//		실제로 삭제시 다시 공간을 재생성하기 때문에 실제 지우지 않고 마크 표시로 처리하는데 이 작업을 반복하면 얽히고 섥혀서 관리가 안되어 에러로 반환함
//		매번 발생하지 않고, 어느 특정 시점에서 발생함, 인덱스 순차 관리가 안되어 에러 발생.
		// Iterable 인터페이스를 통한 삭제를 권장
		// iterator라는 주머니를 생성해 데이터를 가져다 넣음
		// 추가, 제거, 수정 작업을 주머니에서 작업하고 > 기존 배열을 싹 지우고 다시 채워넣음
		// 있는걸 사이 사이 빼고 넣고 하는 작업을 하면 에러가 발생하는데 주머니를 거쳐서 작업 후 다 지운 후 다시 집어넣는 프로세스로 진행
		
		List<String> list4 = new ArrayList<String>();
		list4.add("java");		list4.add("mysql");
		list4.add("html");		list4.add("css");
		list4.add("java");		list4.add("css");
		
		list4.forEach(System.out::println);
		
		System.out.println("-------------------------------------");
		
		Iterator<String> ie = list4.iterator(); // 순차 순회가 안되므로 while문을 사용
		while(ie.hasNext()) { // 손을 넣고 데이터가 있으면
//			System.out.println(ie.next()); // 데이터를 꺼내라
			
			String element = ie.next();
//			System.out.println(element);
			
			if(element.equals("html")) ie.remove();
		}
		list4.forEach(System.out::println);
		// while이 시작되면 주머니에 커서를 넣고 >
		// next로 값을 가져오고 >
		// if와 equals로 동일한 값인지 대조
		// 맞다면 remove로 지우고, 틀리다면 while문을 빠져나오고 다시 재진입해 while이 동작하기 전까지 재반복
		
	}

}

















