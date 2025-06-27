package chatper05;

import java.util.Scanner;

/*
 * 
 */

public class GugudanVer1 {

	public static void main(String[] args) {
		
//		// 1. 구구단 2단 출력 먼저 구축
//		System.out.println("2단");
//		System.out.println("------------");
//		for(int i=1;i<=9;i++) {
//			System.out.println("2 * " + i + " = " + (2*i)); // 앞에 문자가 있어 실행하려면 한번 감싸야함
//		}
		
		
		
//		// 2. 스캐너 추가로 다른 단수 출력
//		Scanner scan = new Scanner(System.in);
//		int dan = 0;
		
//		// 1. 구구단 2단 출력 먼저 구축
//		System.out.println("dan > ");
//		dan = scan.nextInt();
//		
//		System.out.println(dan + "단");
//		System.out.println("------------");
//		for(int i=1;i<=9;i++) {
//			System.out.println(dan + " * " + i + " = " + (dan*i)); // 앞에 문자가 있어 실행하려면 한번 감싸야함
//		}
		
		
		
		// 2. 스캐너 추가로 다른 단수 출력
		Scanner scan = new Scanner(System.in);
		int dan = 0;
		
		// 1. 구구단 2단 출력 먼저 구축
		System.out.println("출력하실 구구단을 입력해주세요.");
		
		while(true) {
			System.out.println("dan(종료:0) > ");
			dan = scan.nextInt();
			
			if(dan != 0) { // dan 변수값이 0이 아닌 경우 : 구구단 출력
				System.out.println(dan + "단");
				System.out.println("------------");
				for(int i=1;i<=9;i++) {
					System.out.println(dan + " * " + i + " = " + (dan*i)); // 앞에 문자가 있어 실행하려면 한번 감싸야함
				}
			} else { // dan 변수값이 0인 경우 : 프로그램 종료
				System.out.println("- 프로그램 종료 -");
				System.exit(0);
			}
		} // while
	} // main
	
} // class
