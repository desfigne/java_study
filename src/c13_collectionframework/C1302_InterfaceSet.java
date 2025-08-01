package c13_collectionframework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C1302_InterfaceSet {

	public static void main(String[] args) {
		
		Set<String> foods = new HashSet<String>();

		// 1. 데이터 저장 : C(Create)
		foods.add("된장찌개");
		foods.add("김치찌개");
		foods.add("짜장면");
//		foods.add("짜장면"); // 중복 데이터 저장X

		// 2. 데이터 출력 : R(Read)
		foods.forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		// 3. 데이터 수정 : U(Update)
		// 짜장면 -> 짬뽕
		if(foods.contains("짜장면")) foods.remove("짜장면");
		foods.add("짬뽕");
		foods.forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		// 4. 데이터 삭제 : D(Delete)
		// 김치찌개 삭제
//		if(foods.contains("김치찌개")) foods.remove("김치찌개"); // 보통 이렇게 사용함
		Iterator ie = foods.iterator(); // 제너릭으로 타입을 제한하지 않으면 Object 타입으로 생성됨
		while(ie.hasNext()) {
//			String food = ie.next(); // 디폴트 타입 오브젝트라서 스트링 타입에 에러가 뜸
			String food = (String)ie.next();
			if(food.equals("김치찌개")) ie.remove();
		}
		foods.forEach(System.out::println);
		
	}

}
