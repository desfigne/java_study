package chapter04;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요.");
		
		int age = 19;
		boolean isMember= true;
		
		String result = (age>=20 && isMember) ? "성인 회원" : "조건 미달";
		System.out.println(result);
		
		int score = 55;
		boolean isRetake = true;
		
		String result2 = (score >= 60 || isRetake) ? "통과" : "탈락";
		System.out.println(result2);
		
		
	}

}
