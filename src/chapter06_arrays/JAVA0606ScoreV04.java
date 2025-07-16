package chapter06_arrays;

import java.util.Scanner;

/*
* 버전 03의 점수 저장을 2차원 배열 구조로 수정함
*/

public class JAVA0606ScoreV04 {

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
        
        System.out.println("크기입력 > ");
        final int MAX_SIZE = scan.nextInt();
        
        // 배열 선언
        String[] nameList = new String[MAX_SIZE];
        int[][] scoreList = new int[MAX_SIZE][];
        
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
                
                // 학생 정보 입력
                for (int i = count; i < MAX_SIZE; i++) {
                	String[] subjectList = {"국어", "영어", "수학"};
					System.out.print("학생명 > ");
					nameList[i] = scan.next();
					
					// 학생의 점수를 입력할 배열을 생성함
					scoreList[i] = new int[5];
					
					int tot = 0;
					int avg = 0;
//					for(int j = 0; j < scoreList[i].length -2; j++) {
					for(int j = 0; j < subjectList.length; j++) {
						System.out.print(subjectList[j] + " > ");
						scoreList[i][j] = scan.nextInt();
						tot += scoreList[i][j];
						avg = tot/3;
					}

					scoreList[i][scoreList[i].length -2] = tot;
					scoreList[i][scoreList[i].length -1] = avg;

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
					for (int i = 0; i < count; i++) {
						System.out.print(nameList[i] + "\t");
						for(int j = 0; j < scoreList[i].length; j++) {
							System.out.print(scoreList[i][j] + "\t");							
						}
						System.out.println();
					}
					System.out.println("\n-----------------------------------------------");
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
			                
			                for (int score : scoreList[searchIdx]) {
			                    System.out.print(score + "\t");
			                }
			                
			                System.out.println("\n-----------------------------------------------");
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