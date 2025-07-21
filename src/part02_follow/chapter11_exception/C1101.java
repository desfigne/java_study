package part02_follow.chapter11_exception;

import java.util.Scanner;

public class C1101 {

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
			System.out.println(numbers[5]);
		} catch(ArithmeticException ae) {
			System.out.println("num2는 0을 입력할 수 없습니다.");
		} catch(ArrayIndexOutOfBoundsException aae) {
			System.out.println("배열의 index 범위를 넘습니다."); // 아무것도 표시 안되길 희망할 경우 빈칸으로 처리
			System.out.println(aae);
		}

	}

}
