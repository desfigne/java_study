package c12_basicapi;

import java.util.HashMap;
import java.util.Scanner;

public class C1205_HashMap {

	public static void main(String[] args) {

		HashMap map = new HashMap(); // 타입을 정의하지 않으면 모든 타입이 들어감
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("name", "hong");
		map2.put("age", "10");
		
		map.put("name", "홍길동");
		map.put("age", 10);
		map.put("scan", new Scanner(System.in));
		
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("scan"));

	}

}
