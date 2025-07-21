package part02_follow.chapter09_interface;

import java.util.List;
import java.util.Vector;

/**
 * Collection의 클래스들이 인터페이스 기반으로 설계가 됨
 * 인터페이스 기반으로 객체 생성하는 것을 권장함
 */

public class C0906_Collection {

	public static void main(String[] args) {

//		List list = new ArrayList();
//		List<String> list = new ArrayList<String>(); // 10개의 공간이 생기고 모두 찼을때, 자동으로 5개씩 증가
		List<String> list = new Vector<String>();
		list.add("홍길동");
		
		System.out.println(list.get(0));

	}

}
