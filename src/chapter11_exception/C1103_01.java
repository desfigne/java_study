package chapter11_exception;

import java.util.Scanner;

public class C1103_01 {

	public static void main(String[] args) {
		
		String name1 = "홍길동";
		String name2 = null;
		C1103_02_Object eo = null;
		eo = new C1103_02_Object();
		eo.name = "홍길동";

//		if(name1.equals(name2)) {
		try {
			if(name1.equals(eo.name)) { // 문법적으로는 틀리지 않았으나 메모리 상에 올려진 데이터값이 없기에 런타임 에러가 발생함
				System.out.println("동일");
			} else {
				System.out.println("다름");
			}
		} catch(NullPointerException ne) {
			System.out.println("NullPointerException 발생"); // 널포인트익셉션일 경우에는 반드시 수정하고 넘어가야 함
			ne.printStackTrace();
		}
	}

}
