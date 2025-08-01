package c06_arrays;

import java.util.Scanner;

/*
 * 더조은 레스토랑 메뉴 등록/출력/검색 프로그램
 * - 메뉴는 피자, 햄버거, 라멘, 샐러드
 * - 메뉴명, 이모지, 가격을 저장
 * - 메뉴명, 이모지, 가격은 각각 1차원 배열로 생성하여 관리
 * - 메뉴 관리를 위해서 각 배열의 주소를 통일시킨다
 */

public class C0607_Menu_V01 {

	public static void main(String[] args) {

		// 01. 변수 or 객체 선언
		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 개수 > ");
		final int MAX_SIZE = scan.nextInt();
		
		String[] nameList =  new String[MAX_SIZE];
		String[] emojiList =  new String[MAX_SIZE];
		int[] priceList =  new int[MAX_SIZE];
        
        int count = 0; // 등록된 메뉴수 저장
		
		// 02. 메뉴 등록/출력/검색/종료
		boolean menuFlag = true;
		int menu = 0;
		int menuCount = 0; // 메뉴 등록 완료시 ++
		
		while(menuFlag) {
			System.out.println("-----------------------------------------------");
    		System.out.println("----- 더조은 레스토랑 메뉴 관리 프로그램 -----");
    		System.out.println("-----------------------------------------------");
    		System.out.println("1. 메뉴 등록");
    		System.out.println("2. 메뉴 리스트 출력");
    		System.out.println("3. 메뉴 검색");
    		System.out.println("9. 프로그램 종료");
    		System.out.println("-----------------------------------------------");
			System.out.println("메뉴 > ");
			menu = scan.nextInt();
			
			if(menu == 1) {
				// 1. 저장공간의 크기만큼 반복수행, 메뉴 하나 등록 완료시 카운트 변수 1증가
				// 2. 저장공간의 크기가 부족하면 메시지 출력 후 종료
				System.out.println("등록");
				for (int i = menuCount; i < MAX_SIZE; i++) {
					System.out.print("메뉴명 > ");
					nameList[i] = scan.next();

					System.out.print("이모지 > ");
					emojiList[i] = scan.next();
					
					System.out.print("가격 > ");
					priceList[i] = scan.nextInt();
					
					menuCount++;
					
					if(menuCount >= MAX_SIZE) {
						System.out.println("저장공간 부족, 등록 종료");
					} else {
						System.out.println("계속 등록 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
						if (scan.next().equals("n")) {
							i = MAX_SIZE;
	
							System.out.println(">> 등록 완료");
						}
					}
				}
			} else if(menu == 2) {
				System.out.println("출력");
				if (menuCount != 0) {
					System.out.println("-----------------------------------------------");
					System.out.println("메뉴명\t이모지\t가격");
					System.out.println("-----------------------------------------------");
					for (int i = 0; i < nameList.length; i++) {
						if (nameList[i] != null) { // 메뉴명이 null이 아닌 경우에만 출력
							System.out.print(nameList[i] + "\t");
							System.out.print(emojiList[i] + "\t");
							System.out.print(priceList[i] + "\n");
						}
					}
					System.out.println("-----------------------------------------------");
				} else {
					System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
				}
			} else if(menu == 3) {
				if (menuCount != 0) {
					System.out.println("검색");
					boolean searchFlag = true;
					while(searchFlag) {
						System.out.println("검색메뉴 > ");
						String searchMenu = scan.next();
						
						// for문으로 저장된 데이터 비교
						int searchIdx = -1; // 지역변수는 꼭 초기화 필요
						for(int i=0; i<menuCount; i++) { // 들어있는 값에서 비교하므로 null 필요없음
							if(searchMenu.equals(nameList[i])) searchIdx = i;
						}
						System.out.println("searchIdx :" + searchIdx);
						
						// 출력 : searchIdx가 -1이 아닌 경우
						if(searchIdx == -1) {
							System.out.println("=> 검색 메뉴 없음");
						} else {
							System.out.println("-----------------------------------------------");
							System.out.println("메뉴명\t이모지\t가격");
							System.out.println("-----------------------------------------------");
							System.out.print(nameList[searchIdx] + "\t");
							System.out.print(emojiList[searchIdx] + "\t");
							System.out.print(priceList[searchIdx] + "\n");
						}
						
						System.out.println("계속 검색 하시겠습니까? (계속: 아무키나 누르세요, 종료: n) >");
						if (scan.next().equals("n")) {
							searchFlag = false;
	
							System.out.println(">> 검색 종료");
						}
					}
				} else {
					System.out.println("등록된 데이터가 없습니다. 등록을 진행해주세요.");
				}
			} else if(menu == 9) {
				System.out.println("-- 프로그램 종료 --");
				System.exit(0);
			} else {
				System.out.println("=> 메뉴 준비중");
			}
		}
		
	}

}
