package chatper05;

import java.util.Scanner;

/*
 * 
 */

public class ForOverlabTest {

	public static void main(String[] args) {
		
//		// 2단 ~ 9단 출력
//		for(int i=1; i<=9; i++) { // 세로 줄 수치 제어
//			for(int j=2; j<=9; j++) { // 가로 줄 수치 제어
//				System.out.print(j + "x" + i + "=" + (i*j)+"\t");
//			}
//			System.out.println("");
//		}
		
		
		
//		Scanner scan = new Scanner(System.in);
//		int start = 0, end = 0;
//		
//		System.out.println("start >");
//		start = scan.nextInt();
//		
//		System.out.println("end >");
//		end = scan.nextInt();
//		
//		for(int i=1; i<=9; i++) { // 세로 줄 수치 제어
//			for(int j=start; j<=end; j++) { // 가로 줄 수치 제어
//				System.out.print(j + "x" + i + "=" + (i*j)+"\t");
//			}
//			System.out.println("");
//		}

		System.out.println("프로그램 종료 : start , end 모두 0 입력");
		
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0;
		
		boolean flag = true;

		while(flag) {
			
			System.out.println("start >");
			start = scan.nextInt();
			
			System.out.println("end >");
			end = scan.nextInt();
			
			// 실행여부 체크
			if(start == 0 && end == 0) {
				// while 블록을 빠져 나간 후 종료
				flag = false;	
//				System.out.println("-- 프로그램 종료 --");
//				System.exit(0);
			} else {
				for(int i=1; i<=9; i++) { // 세로 줄 수치 제어
					for(int j=start; j<=end; j++) { // 가로 줄 수치 제어
						System.out.print(j + "x" + i + "=" + (i*j)+"\t");
					}
					System.out.println("");
				}
				System.out.println("프로그램 종료 : start , end 모두 0 입력");
			}
		} // while
		
		System.out.println("-- 프로그램 종료 --");
		System.exit(0);
	} // main

}
