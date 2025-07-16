package chapter11_exception;

import java.util.Scanner;

public class C1102 {

	public static void main(String[] args) {
		
		int result2 = 100/2;
		System.out.println("result2 : " + result2);

//		int result3 = 100/0;
//		System.out.println("result3 : " + result3);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("num1 : ");
		int num1 = scan.nextInt();
		System.out.print("num2 : ");
		int num2 = scan.nextInt();
		
//		int result1 = num1/num2;
//		System.out.println("result1 : " + result1);
		
		try {
			int result = num1/num2;
			System.out.println("result : " + result);
			int[] numbers = {1, 2, 3};
			System.out.println(numbers[0]);
//			System.out.println(numbers[5]);
		} catch(Exception ae) {
			System.out.println("예외 발생");
			ae.printStackTrace();
		} finally {
			scan.close(); // 메인 메소드에서 다 종료해주기 때문에 생략은 가능함
			System.out.println(" -- 프로그램 종료 -- ");
		}

	}

}
