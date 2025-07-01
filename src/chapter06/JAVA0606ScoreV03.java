package chapter06;

import java.util.Scanner;

/*
* 버전 02의 결과에 메뉴를 추가함 / 현재 누적 카운트 동작 안하는거 강사님 코드랑 비교분석 필요
*/

public class JAVA0606ScoreV03 {

	public static void main(String[] args) {

		// 01. 메뉴 구성

//		System.out.println("-----------------------------------------------");
//		System.out.println("----- 더조은 고등학교 1-1 성적관리 프로그램 -----");
//		System.out.println("-----------------------------------------------");
//		System.out.println("1. 학생 등록");
//		System.out.println("2. 학생 리스트 출력");
//		System.out.println("3. 학생 성적 검색");
//		System.out.println("9. 프로그램 종료");
//		System.out.println("-----------------------------------------------");

        // 변수 선언 (while 바깥에서 선언)
        Scanner scan = new Scanner(System.in);
        int menu = 0; // 2. 겹치는 메뉴 없으니 초기화 0값 지정
        boolean menuFlag = true; // 6.
        
        // 배열 선언
        String[] nameList = null;
        int[] korList = null;
        int[] engList = null;
        int[] mathList = null;
        int[] totList = null;
        int[] avgList = null;
        int MAX_SIZE = 0;
        
        int count = 0; // 등록된 학생수 저장

        while (menuFlag) { // 7.
    		System.out.println("-----------------------------------------------"); // 16. 
    		System.out.println("----- 더조은 고등학교 1-1 성적관리 프로그램 -----");
    		System.out.println("-----------------------------------------------");
    		System.out.println("1. 학생 등록");
    		System.out.println("2. 학생 리스트 출력");
    		System.out.println("3. 학생 성적 검색");
    		System.out.println("9. 프로그램 종료");
    		System.out.println("-----------------------------------------------");
        	
            System.out.print("메뉴선택 (숫자) > "); // 3.
            menu = scan.nextInt();

            if (menu == 1) { // 10.
				// 16.
                System.out.print("등록할 학생의 수를 입력해주세요. > ");
                MAX_SIZE = scan.nextInt();
                
                nameList = new String[MAX_SIZE];
                korList = new int[MAX_SIZE];
                engList = new int[MAX_SIZE];
                mathList = new int[MAX_SIZE];
                totList = new int[MAX_SIZE];
                avgList = new int[MAX_SIZE];

                // 학생 정보 입력
                for (int i = count; i < MAX_SIZE; i++) {
					System.out.print("학생명 > ");
					nameList[i] = scan.next();

					System.out.print("국어 > ");
					korList[i] = scan.nextInt();
					System.out.print("영어 > ");
					engList[i] = scan.nextInt();
					System.out.print("수학 > ");
					mathList[i] = scan.nextInt();

					totList[i] = korList[i] + engList[i] + +mathList[i];
					System.out.print("\n총점 > " + totList[i]);
					avgList[i] = totList[i] / 3;
					System.out.print("평균 > " + avgList[i] + "\n\n");

					count++;
					System.out.println("--------------------------------------------------------");
					System.out.println("계속 입력 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >"); // 4.
					if (scan.next().equals("n")) { // 5. 입력 받은 값이 n이면 종료
						// break; // 자연스러운 종료는 브레이크보다 트루 펄스로 종료하는게 낫다
						i = nameList.length;

						System.out.println(">> 등록 완료");
					}
				}
			} else if (menu == 2) { // 학생 리스트 출력
				// 17.
				if (count != 0) {
					System.out.println("-----------------------------------------------");
					System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
					System.out.println("-----------------------------------------------");
					for (int i = 0; i < nameList.length; i++) {
						if (nameList[i] != null) {
							System.out.print(nameList[i] + "\t");
							System.out.print(korList[i] + "\t");
							System.out.print(engList[i] + "\t");
							System.out.print(mathList[i] + "\t");
							System.out.print(totList[i] + "\t");
							System.out.print(avgList[i] + "\n");
						}
					}
					System.out.println("-----------------------------------------------");
				} else {
					System.out.println("등록된 학생이 없습니다.");
				}
			} else if (menu == 3) { // 학생 성적 검색
			    // 1) 등록된 학생이 하나도 없으면 바로 메시지 출력
			    if (count == 0) {
			        System.out.println("=> 등록된 학생이 없습니다.");
			        
			    } else {
			        // 2) 등록된 학생이 있으면 기존 검색 로직 실행
			        boolean searchFlag = true;
			        
			        while (searchFlag) {
			            System.out.print("학생명 검색 > ");
			            String searchName = scan.next();
			            
			            int searchIdx = -1;
			            int countIdx = 0;
			            for (String name : nameList) {
			                if (name != null) {
			                    if (name.equals(searchName)) {
			                        searchIdx = countIdx;
			                        break;
			                    }
			                }
			                countIdx++;
			            }
			            
			            if (searchIdx != -1) {
			                System.out.println("검색결과 주소 : " + searchIdx);
			                
			                System.out.println("-----------------------------------------------");
			                System.out.println("\t검색 결과");
			                System.out.println("-----------------------------------------------");
			                System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
			                System.out.println("-----------------------------------------------");
			                System.out.print(nameList[searchIdx] + "\t");
			                System.out.print(korList[searchIdx] + "\t");
			                System.out.print(engList[searchIdx] + "\t");
			                System.out.print(mathList[searchIdx] + "\t");
			                System.out.print(totList[searchIdx] + "\t");
			                System.out.print(avgList[searchIdx] + "\n");
			                
			                System.out.println("--------------------------------------------------------");
			                System.out.println("계속 검색 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
			                if (scan.next().equals("n")) {
			                    searchFlag = false;
			                }
			                
			            } else {
			                // 3) 검색어는 있으나 일치하는 데이터가 없을 때
			                System.out.println("=> 검색한 데이터가 없습니다.");
			                // 원하는 동작에 따라 반복을 종료하거나 계속 둘 수 있습니다.
			                searchFlag = false;
			            }
			        }
			    }
			} else if (menu == 9) { // 11. 프로그램 종료
				// menuFlag = false; // 12.
				System.out.println("-- 프로그램 종료 --"); // 13.
				System.exit(0); // 14.
			} else {
				System.out.println("메뉴 준비중입니다.");
			}
		} // while

		System.out.println("-- 프로그램 종료 --"); // 9.

	}

}