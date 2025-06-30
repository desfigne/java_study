package chapter05;

import java.util.Scanner;

/*
 * 반복문 : while(조건식) { 실행문(조건식이 true인 경우에만 실행); }
 *        종료되는 시점을 정확하게 알고 있는 경우 사용됨
 */

public class JAVA0503While01 {

	public static void main(String[] args) {

//		// 1~10까지 증감을 출력
//		// 스캐너 먼저 넣지 말고, 고정된 값을 구성 후 스캐너로 전환을 권장
//		
//		int i = 1; // for문이나 while문 안에 정의할 경우 무한루프에 들어가기에 꼭 위 바깥에 정의
//		while(i<=10) {
//			System.out.println("i = " + i);
//			i++;
//		}
//
//		
//		
//		// 1~10까지 정수의 합계까지를 출력
//		// 스캐너 먼저 넣지 말고, 고정된 값을 구성 후 스캐너로 전환을 권장
//		
//		int i = 1; // for문이나 while문 안에 정의할 경우 무한루프에 들어가기에 꼭 위 바깥에 정의
//		int sum = 0;
//		while(i<=10) {
//			sum += i;
//			i++;
//			System.out.println("sum = " + sum);
//		}
//
//		
//		
//		// 1~10까지 정수의 합계를 출력
//		// 스캐너 먼저 넣지 말고, 고정된 값을 구성 후 스캐너로 전환을 권장
//		
//		int i = 1; // for문이나 while문 안에 정의할 경우 무한루프에 들어가기에 꼭 위 바깥에 정의
//		int sum = 0;
//		while(i<=10) {
//			sum += i;
//			i++;
//		}
//		System.out.println("sum = " + sum);

		
		
		// 1~10까지 정수의 합계를 출력
		// 시작과 종료값은 실행시 외부에서 입력을 통해 진행함
		
		Scanner scan = new Scanner(System.in);
		int start = 0, end = 0, i = 1, sum = 0; // 가독성을 위해 이렇게도 배치 가능
//		int i = 1;
//		int sum = 0;
		
		System.out.println("start > ");
		i = start = scan.nextInt();
//		i = start
		
		System.out.println("end > ");
		end = scan.nextInt();
		
		while(i<=end) {
			sum += i;
			i++;
		}
		System.out.println("sum = " + sum);

	}

}
