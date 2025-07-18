package chapter13_collectionframework;

import java.util.HashMap;
import java.util.Map;

public class C1303_InterfaceMap__2 {

	public static void main(String[] args) {
		
		Map<Integer, String> subjects = new HashMap<Integer, String>();

		// 1. 데이터 저장 : C(Create)
		subjects.put(1, "java");
		subjects.put(2, "mysql");
		subjects.put(3, "html");
		subjects.put(4, "css");
		

		// 2. 데이터 출력 : R(Read)
//		subjects.forEach(System.out::println); // 클래스 참조 형식의 람다코드는 사용 X, 값이 명확하지 않음, 키값인지 밸류값인지 확인안됨
//		subjects.forEach((key, value) -> { // 하나의 값은 지워지나, 키 밸류 값은 지워짐 불가
//			System.out.println(key + ", " + value);
//		});
		subjects.forEach((key, value) -> System.out.println(key + ", " + value));
		
		System.out.println("------------------------------");
		
		
		// 3. 데이터 수정 : U(Update)
		// mysql --> oracle
//		if(subjects.containsKey(2)) subjects.put(2, "oracle");
		if(subjects.containsKey(2)) subjects.replace(2, "oracle");
		subjects.forEach((key, value) -> System.out.println(key + ", " + value));
		
		System.out.println("------------------------------");
		
		
		// 4. 데이터 삭제 : D(Delete)
		// 이터레이터는 안해도 됨, 리스트할때 사용
		// oracle 삭제
		subjects.remove(2);
		subjects.forEach((key, value) -> System.out.println(key + ", " + value));
		
		System.out.println("------------------------------");
		
		subjects.clear();// 전체 삭제
		System.out.println(" -- 전체 삭제 완료 -- ");
		subjects.forEach((key, value) -> System.out.println(key + ", " + value));
		
	}

}
