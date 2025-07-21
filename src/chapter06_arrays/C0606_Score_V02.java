package chapter06_arrays;

import java.util.Scanner;

/*
 * 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
 * - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
 * - 과목은 국어, 영어, 수학 3과목의 점수를 입력
 * - 입력받은 과목의 총점과 평균을 구함
 * - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
 * - 입출력을 위해서 각 배열의 주소를 통일시킨다
 * - 프로그래밍 방식 : 2가지 방식
 *   - 1. 구조적(Structured) 방식 : 순차적으로 내려오면서 위로 올라가서 다시 내려오는 방식, 코드를 재사용 불가하니 순서대로 실행할때 다 넣어야 함
 *   - 2. 객체지향적(OOP, Object Oriented) 방식
 */

public class C0606_Score_V02 {

	public static void main(String[] args) {

		System.out.println("-----------------------------------------------");
		System.out.println("----- 더조은 고등학교 1-1 성적관리 프로그램 -----");		
		System.out.println("-----------------------------------------------");
		
		// Step 01 : 배열, 변수 선언
		
		Scanner scan = new Scanner(System.in);
		System.out.println("등록할 학생의 수를 입력해주세요. > ");
		final int MAX_SIZE = scan.nextInt(); // 27. 입력받는 숫자가 바뀌도록 바꾸는 작업
		
//		String[] nameList = "홍길동, 이순신, 김유신, 강감찬, 홍길순";
//		String[] nameList = new String[5];
		
//		int[] korList = new int[5];
//		int[] engList = new int[5];
//		int[] mathList = new int[5];
//		int[] totList = new int[5];
//		int[] avgList = new int[5];
		
		String[] nameList = new String[MAX_SIZE]; // 28.
		int[] korList = new int[MAX_SIZE];
		int[] engList = new int[MAX_SIZE];
		int[] mathList = new int[MAX_SIZE];
		int[] totList = new int[MAX_SIZE];
		int[] avgList = new int[MAX_SIZE];
		
		// Step 02 : 데이터 입력 - 실행시 외부에서 입력 (5번 반복으로 회수가 정해져있어 for문 사용, 회수가 안정해져있으면 while문 사용)
		
		for(int i = 0; i < nameList.length; i++) { // 1. 5번 반복 먼저 구성
			System.out.print("학생명 > ");
			nameList[i] = scan.next(); // 2. 입력 받기 위해 스캔이 대기 > 이름 목록의 i번 째에 들어감
			
			System.out.print("국어 > "); // 6. 숫자이기 때문에 next가 아닌 nextInt
			korList[i] = scan.nextInt();
			System.out.print("영어 > ");
			engList[i] = scan.nextInt();
			System.out.print("수학 > ");
			mathList[i] = scan.nextInt(); // 11. 압축해서 처리 가능, v01파일 참조
			
			totList[i] = korList[i] + engList[i] + + mathList[i]; // 총점
			System.out.print("\n총점 > " + totList[i]); // 7. 입력 받지 않고 더해서 출력
			avgList[i] = totList[i] /3;
			System.out.print("평균 > " + avgList[i] + "\n\n");                          // 평균
			
			System.out.println("--------------------------------------------------------");
			System.out.println("계속 입력 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >"); // 4.
//			if(scan.next() == "n") { // 주소값으로 대조하기에 이렇게 사용X
			if(scan.next().equals("n")) { // 5. 입력 받은 값이 n이면 종료
//				break; // 자연스러운 종료는 브레이크보다 트루 펄스로 종료하는게 낫다
				i = nameList.length;
			}
		}
		
		// Step 03 : 데이터 출력
		
		System.out.println("-----------------------------------------------");
		System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
		System.out.println("-----------------------------------------------");
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
		System.out.println("-----------------------------------------------");
		
		
		boolean searchFlag = true; // 23. 디폴트는 무조건 돌도록 true
		
		while(searchFlag) { // 22. 검색 결과 이후 프로그램 종료됨, while, 검색플래그, 데이터 조회 구간이 반복되어야 함, 24. 검색플래그 대신 true 값을 넣으면 무한루프에 빠짐
			
			// Step 04 : 데이터 조회 / 데이터 등록이 완료된 이후 조회 가능

			// 12. 조회할 학생명 입력
			System.out.print("학생명 검색 > ");
			String searchName = scan.next(); // 13.
			// nameList에서 입력한 학생명 검색 --> 학생의 nameList 주소를 변수에 저장한다. (학생명과 네임리스트의 이름이 주소값으로 등록되어 있어 이퀄스로 처리해야 함)
			
			int searchIdx = -1; // 17. 배열의 인덱스 값이 아닌 값을 지정해줘야 함
			int count = 0; // 15. 배열이니 숫자 0
			for(String name : nameList) { // 14. 
//			if(name.equals(searchName)); // 16. 
				if(name != null) { // 20.
					if(name.equals(searchName)) searchIdx = count; // 17. 
					count++; // 18.
				}
			}
			System.out.println("검색결과 주소 : " + searchIdx); // 19.
			
			// Step 05 : 데이터 조회 결과 출력
			
			System.out.println("-----------------------------------------------");
			System.out.println("\t검색 결과");
			System.out.println("-----------------------------------------------");
			System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
			System.out.println("-----------------------------------------------");
			System.out.print(nameList[searchIdx] + "\t"); // 21.
			System.out.print(korList[searchIdx] + "\t");
			System.out.print(engList[searchIdx] + "\t");
			System.out.print(mathList[searchIdx] + "\t");
			System.out.print(totList[searchIdx] + "\t");
			System.out.print(avgList[searchIdx] + "\n");
			
			System.out.println("--------------------------------------------------------"); // 24. 
			System.out.println("계속 검색 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
//			if(scan.next() == "n") { // 주소값으로 대조하기에 이렇게 사용X
			if(scan.next().equals("n")) { // 입력 받은 값이 n이면 종료
//				break; // 자연스러운 종료는 브레이크보다 트루 펄스로 종료하는게 낫다.
				searchFlag = false; // 25. 
			}
			
		} // while - searchFlag : Step4, Step5 반복

		System.out.println("-- 프로그램 종료 --"); // 26. 
	} // main

} // class
