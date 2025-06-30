package chapter05;

import java.util.Scanner;

/*
 * 반복문 : for(초기값선언; 조건식; 증감연산식) { 실행문(조건식이 true인 경우 실행); }
 *        조건식이 false가 되면 for 블록 종료
 *        초기값으로 선언된 변수는 for 블록 안에서만 사용
 */

public class JAVA0504For01 {

	public static void main(String[] args) {
		
		// 1~5까지 정수 출력
		for(int i=1; i<=5; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("-- for 문 종료 --");
		
		// 1~10까지 정수 출력
		for(int i=1; i<=10; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("-- for 문 종료 --");
		
//		// 시작점부터 끝점까지 정수 출력
//		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
//		Scanner scan = new Scanner(System.in);
//		int start = 0, end = 0;
//		System.out.println("시작값 > ");
//		start = scan.nextInt();
//		
//		System.out.println("종료값 > ");
//		end = scan.nextInt();
//		
//		for(int i=start; i<end; i+=10) { // 1 이상의 값을 누적합으로 작성 i += 값
//			System.out.println("i = " + i);
//		}
////		System.out.println(i); 에러 : i의 블록 범위는 for 블록
//		System.out.println("-- for 문 종료 --");
		
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0;
		System.out.println("시작값 > ");
		start = scan.nextInt();
		
		System.out.println("종료값 > ");
		end = scan.nextInt();
		
		int sum = 0; // 초기화해서 또 실행 처리하기에 0으로 다시 0으로 회귀되어 버림
		for(int i=start; i<end; i++) { // 1 이상의 값을 누적합으로 작성 i += 값
			sum += i;
			System.out.println("sum = " + sum);
		}
//		System.out.println(i); 에러 : i의 블록 범위는 for 블록
		System.out.println("-- for 문 종료 --");
	}

}
