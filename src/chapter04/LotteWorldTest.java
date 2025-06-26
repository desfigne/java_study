package chapter04;

import java.util.Scanner;

public class LotteWorldTest {

	public static void main(String[] args) {

		// AND(&&) : 두 개의 항의 결과가 모두 true인 경우에만 실행결과가 true
		// OR(||) : 두 개의 항의 결과 중 하나라도 true이면 실행결과가 true
		// NOT(!) : 결과를 반대의 boolean 값으로 변경
		
		// 놀이기구 탑승 전 체크사항
		// 1. 6세 이상 탑승 가능 (단, 6세 이하는 키가 120cm 이상이고 보호자 동반하에 탑승가능)
		// 2. 키 120cm 이상 탑승 가능
		// 3. 심장질환자는 탑승 불가
		
		Scanner input = new Scanner(System.in);
		
		// 지역변수를 선언하는 경우에는 반드시 초기화를 진행함
		String name = ""; // 클래스는 null값으로 초기화 가능 / "" 빈값 또는 null
		int age = 0, height = 0;
		boolean parent = false, dease = false;
		
		System.out.println("*************************");
		System.out.println("놀이기구 탑승전 유의사항 및 체크");
		System.out.println("*************************");
		
		System.out.print("이름 > ");
		name = input.next();
		
		System.out.print("나이 > ");
		age = input.nextInt();
		
		System.out.print("신장 > ");
		height = input.nextInt();
		
		System.out.print("부모님 동반(동반O:1, 동반X:0) > ");
		parent = (input.nextInt() == 1)? true : false;
		
		System.out.print("심장 질환(유:1, 무:0) > ");
		dease = (input.nextInt() == 1)? true : false;
		
//		System.out.println(name + "," + age + "," + height + "," + parent + "," + dease);
		
		// ((6세 이상 + 키 120 이상) || (6세 미만 + 키 120 이상 + 보호자 유)) && (심장질환)
		// (age>=6) && (height>=120)   (age<6) && (height>=120) && (parent==true)   (dease==false)
		
		String result = (((age>=6) && (height>=120)) || ((age<6) && (height>=120) && (parent==true))) && (dease==false)? "탑승가능" : "탑승 불가능";
		System.out.println("result : " + result);
	}

}
