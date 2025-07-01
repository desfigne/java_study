package chapter06;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입출력을 위해서 각 배열의 주소를 통일시킨다
 */

public class JAVA0606ScoreV02 {

	public static void main(String[] args) {

		System.out.println("-----------------------------------------------");
		System.out.println("----- 더조은 고등학교 1-1 성적관리 프로그램 -----");		
		System.out.println("-----------------------------------------------");
		
		// Step 01 : 배열, 변수 선언
		
		Scanner scan = new Scanner(System.in);
//		String[] nameList = "홍길동, 이순신, 김유신, 강감찬, 홍길순";
		String[] nameList = new String[5];
		int[] korList = new int[5];
		int[] engList = new int[5];
		int[] mathList = new int[5];
		int[] totList = new int[5];
		int[] avgList = new int[5];
		
		// Step 02 : 데이터 입력 - 실행시 외부에서 입력 (5번 반복으로 회수가 정해져있어 for문 사용, 회수가 안정해져있으면 while문 사용)
		
		for(int i = 0; i < nameList.length; i++) { // 1. 5번 반복 먼저 구성
			System.out.print("학생명 > ");
			nameList[i] = scan.next(); // 2. 입력 받기 위해 스캔이 대기 > 이름 목록의 i번 째에 들어감
			
			System.out.print("국어 > "); // 6. 숫자이기 때문에 next가 아닌 nextInt
			korList[i] = scan.nextInt();
			System.out.print("영어 > ");
			engList[i] = scan.nextInt();
			System.out.print("수학 > ");
			mathList[i] = scan.nextInt();
			
			totList[i] = korList[i] + engList[i] + + mathList[i]; // 총점
			System.out.print("\n총점 > " + totList[i]); // 7. 입력 받지 않고 더해서 출력
			avgList[i] = totList[i] /3;
			System.out.print("평균 > " + avgList[i] + "\n\n");                          // 평균
			
			System.out.println("계속 입력 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >"); // 4.
//			if(scan.next() == "n") { // 주소값으로 대조하기에 이렇게 사용X
			if(scan.next().equals("n")) { // 5. 입력 받은 값이 n이면 종료
//				break; // 자연스러운 종료는 브레이크보다 트루 펄스로 종료하는게 낫다
				i = nameList.length;
			}
		}
		
		// Step 03 : 데이터 출력
		
		for(int i = 0; i < nameList.length; i++) { // 3.
			// 10. 이름이 null이 아닌 경우에만 출력
			if(nameList[i] != null) { // null에 따옴표가 있을 경우 문자열로 인식, 처리
//				System.out.print(nameList[i]);
				System.out.print(nameList[i] + "\t"); // 8.
				System.out.print(korList[i] + "\t");
				System.out.print(engList[i] + "\t");
				System.out.print(mathList[i] + "\t");
				System.out.print(totList[i] + "\t");
				System.out.print(avgList[i] + "\n"); // 9.
			}
		}
		

	} // main

} // class
