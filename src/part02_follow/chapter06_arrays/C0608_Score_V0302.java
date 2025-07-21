package part02_follow.chapter06_arrays;

import java.util.Scanner;

/*
* 더조은 고등학교 1학년 1반 학생들의 성적관리 프로그램
* - 학생은 홍길동, 이순신, 김유신, 강감찬, 홍길순
* - 과목은 국어, 영어, 수학 3과목의 점수를 입력
* - 입력받은 과목의 총점과 평균을 구함
* - 학생명, 과목별 점수, 총점, 평균은 각각 1차원 배열로 생성하여 관리
* - 입출력을 위해서 각 배열의 주소를 통일시킨다
* * 버전 02의 결과에 메뉴를 추가함
* - 학생 성적 수정 메뉴를 추가한다. (검색 + 등록)
* - 학생 데이터 삭제 메뉴를 추가한다. (검색 + i와 count 값 수정)
*   - 배열은 공간은 유지되고 데이터만 삭제 처리
*   - 빈 공간에 뒤의 값들을 앞으로 옮겨야 하는데, 옮기려면 인덱스 i 값을 -1 주고 카운트 count -1 값을 줘야 함
*/

public class C0608_Score_V0302 {

	public static void main(String[] args) {

        // 변수 선언 (while 바깥에서 선언)
        Scanner scan = new Scanner(System.in);
        int menu = 0; // 2. 겹치는 메뉴 없으니 초기화 0값 지정
        boolean menuFlag = true; // 6.
        
        // 배열 선언
        // 16.
        System.out.print("등록할 학생의 수를 입력해주세요. > ");
        final int MAX_SIZE = scan.nextInt();
        
        String[] nameList = new String[MAX_SIZE];
        int[] korList = new int[MAX_SIZE];
        int[] engList = new int[MAX_SIZE];
        int[] mathList = new int[MAX_SIZE];
        int[] totList = new int[MAX_SIZE];
        int[] avgList = new int[MAX_SIZE];
        
        int count = 0; // 등록된 학생수 저장

        while (menuFlag) { // 7.
    		System.out.println("-----------------------------------------------"); // 16. 
    		System.out.println("----- 더조은 고등학교 1-1 성적관리 프로그램 -----");
    		System.out.println("-----------------------------------------------");
    		System.out.println("1. 학생 등록");
    		System.out.println("2. 학생 리스트 출력");
    		System.out.println("3. 학생 성적 검색");
    		System.out.println("4. 학생 성적 수정");
    		System.out.println("5. 학생 삭제");
    		System.out.println("9. 프로그램 종료");
    		System.out.println("-----------------------------------------------");
        	
            System.out.print("메뉴선택 (숫자) > "); // 3.
            menu = scan.nextInt();

            if (menu == 1) { // 10.

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
					for (int i = 0; i < count; i++) {
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
			} else if (menu == 4) { // 학생 성적 수정, 한번 돌게 만들고 와일로 전환이 수월함
				// 수정할 학생명이 존재여부 검새 : 유 -> 새로운 성적 입력 후 수정
				// 수정할 학생명이 존재여부 검새 : 무 -> 검색 데이터 존재X, 반복진행 여부
				 // 1) 등록된 학생이 하나도 없으면 바로 메시지 출력
			    if (count != 0) {
					boolean modiFlag = true;
					
					while (modiFlag) {
						System.out.print("[수정] 학생명 검색 > ");
						String modifiedName = scan.next();
						int modiIdx = -1; // 0으로 지정하면 첫번째 것을 계속 가져옴
						
						for(int i = 0; i<count; i++) { // 또는 향상된 for 문 사용 가능, count 사용시 null포인트인셉션 에러 발생, 있는 것만 카운트 되는게 중요;
							if(nameList[i].equals(modifiedName)) modiIdx = i;
						}
						
						if(modiIdx == -1) { // 데이터가 없을 경우
							System.out.println("수정할 데이터가 존재하지 않습니다. 다시 입력해주세요.");
						} else { // 데이터가 있을 경우
							System.out.print("국어 > ");
							korList[modiIdx] = scan.nextInt();
							
							System.out.print("영어 > ");
							engList[modiIdx] = scan.nextInt();
							
							System.out.print("수학 > ");
							mathList[modiIdx] = scan.nextInt();
		
							totList[modiIdx] = korList[modiIdx] + engList[modiIdx] + +mathList[modiIdx];
							avgList[modiIdx] = totList[modiIdx] / 3;
							// 1차원에서는 인덱스 통일이 중요함
							// 수정 반복하려면 while 문 사용
							
							System.out.println("=> 수정 완료");
			                
			                System.out.println("-----------------------------------------------");
			                System.out.println("\t수정 결과");
			                System.out.println("-----------------------------------------------");
			                System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
			                System.out.println("-----------------------------------------------");
			                System.out.print(nameList[modiIdx] + "\t");
			                System.out.print(korList[modiIdx] + "\t");
			                System.out.print(engList[modiIdx] + "\t");
			                System.out.print(mathList[modiIdx] + "\t");
			                System.out.print(totList[modiIdx] + "\t");
			                System.out.print(avgList[modiIdx] + "\n");
			                
			                System.out.println("--------------------------------------------------------");
			                System.out.println("계속 검색 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
			                if (scan.next().equals("n")) {
			                    modiFlag = false;
			                }
						}
					}
			    } else {
					System.out.println("등록된 데이터가 존재하지 않습니다.");
				}
			} else if (menu == 5) {
				if(count != 0) {
					boolean deleteFlag = true;
					while (deleteFlag) {
						System.out.println("[삭제] 학생명 검색 > ");
						String deleteName = scan.next();
						int deleteIdx = -1;
						for (int i=0; i<count; i++) {
							if(nameList[i].equals(deleteName)) deleteIdx = i;
						}
						
						if(deleteIdx != -1) { // !=와 = 이 다르면 위 아래로 내용도 바뀌는 것 유의
							for (int i = deleteIdx; i < count-1; i++) { // 홍길동(0)   이순신(1)   김유신(2)
																		// 이순신(0)   김유신(1)   김유신(2)
								nameList[i] = nameList[i+1];
								korList[i] = korList[i+1];
								engList[i] = engList[i+1];
								mathList[i] = mathList[i+1];
								totList[i] = totList[i+1];
								avgList[i] = avgList[i+1];
							}
							count--;// length로 하면 앞으로 이동되고 뒤에 그대로 남은 값도 같이 출력됨, count로 관리해줘야 이동된 이름만 출력
							
							System.out.println("=> 삭제 완료");
			                
			                System.out.println("-----------------------------------------------");
			                System.out.println("\t삭제 결과");
			                System.out.println("-----------------------------------------------");
			                System.out.println("학생명\t국어\t영어\t수학\t총합\t평균");
			                System.out.println("-----------------------------------------------");
			                System.out.print(nameList[deleteIdx] + "\t");
			                System.out.print(korList[deleteIdx] + "\t");
			                System.out.print(engList[deleteIdx] + "\t");
			                System.out.print(mathList[deleteIdx] + "\t");
			                System.out.print(totList[deleteIdx] + "\t");
			                System.out.print(avgList[deleteIdx] + "\n");
			                
							System.out.println("--------------------------------------------------------");
			                System.out.println("계속 삭제 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
			                if (scan.next().equals("n")) {
			                	deleteFlag = false;
			                }
						} else {
							System.out.println("삭제할 데이터가 존재하지 않습니다. 다시 입력해주세요.");
						}
					}
				}
			}
			else if (menu == 9) { // 11. 프로그램 종료
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