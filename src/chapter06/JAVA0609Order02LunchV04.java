package chapter06;

/* 
 * 강사님과 코드 비교에서 차이점 확인하기, AI에 수정 요청한 버전인데 이렇게 알려주셨는지 확인이 안됨
 * - 카운트 오더카운트로 바뀌면서 어떻게 전체적으로 변경되었는지 확인하기 트래킹 못함
 * - case 4 결제 아예 없는 상태에서 출력 구조 틀 지금 이상함, 강사님이 어떻게 짜셨는지 확인하기
 * - 그냥 코드 한 줄 한줄 체크해야 할듯, 대체적으로 트래킹 못한듯
 * 
 * 음식 주문/결제 프로그램(콘솔)
 * - 음식을 주문, 결제 프로그램 종료하는 메뉴로 구성된다.
 * - 프로그램 종료를 제외하고 나머지 메뉴는 반복 선택 가능하다.
 * - 메뉴 선택 시 체크하는 기능은 switch~case를 이용하여 구현한다.
 * 
 * << 추가 사항 >>
 * (1) 예외사항 처리
 *     : 메뉴 선택, 결제금액 입력 시 정수형 타입이 아닌 경우 메시지 출력 후 재입력을 유도함
 * (2) 입력값이 정확할 때까지 재입력을 유도하여 진행, flag 변수를 이용하여 반복
 * (3) 결제 금액이 부족한 경우 재입력을 통해 금액을 누적으로 계산하여 저장 후 결제
 */

import java.util.Scanner;

public class JAVA0609Order02LunchV04 {

	public static void main(String[] args) {
		// 01. 메인 메뉴 구성
//		System.out.println("********************************************");
//		System.out.println("\t Welcome to Food Mart!!!");
//		System.out.println("********************************************");
//		System.out.println("\t 1. 음식 주문");
//		System.out.println("\t 2. 음식 결제");
//		System.out.println("\t 9. 나가기");
//		System.out.println("********************************************");
//		System.out.println("\t Food Mart에 오신 것을 환영합니다.");
//		
//		Scanner scan = new Scanner(System.in);
//		boolean menuFlag = true;
//		while(menuFlag) {
//			System.out.println("메뉴 >");
//			int menu = scan.nextInt();
//			
//			switch(menu){
//			case 1 : 
//				System.out.println("=> 주문");
//				break;
//			case 2 : 
//				System.out.println("=> 결제");
//				break;
//			case 9 : 
//				System.out.println("=> -- 프로그램 종료 --");
//				System.exit(0);
//				break;
//			default :
//				System.out.println("=> 메뉴 준비중");
//			}
//
//		} // 에러 체크 후에 다음 단위 구성, 에러 체크 후 다음 단위 구성으로 반복 진행
		// 한번만 나올 경우 푸트 마켓을 여기에 위치
		
//		// 02. 1. 음식 주문 메뉴 구성
//		Scanner scan = new Scanner(System.in);
//		boolean menuFlag = true;
//		
//		// 02. 4. 주문 음식 리스트
//		String[] menuList = {"햄버거(🍔)", "피자요(🍕)", "라멘요(🍜)", "샐러드(🥗)"};
//		int[] priceList = {1000, 2000, 3000, 4000};
//
//		// 02. 3. 주문 리스트 선언 및 생성 
//		//        주문 기록이 반복문을 빠져나와도 기록이 유지되어야 하므로 밖에 배치
//		System.out.println("주문 리스트 크기 > "); // < 02. 13. 3 수치를 MAX_SIZE로 전환
//		final int MAX_SIZE = scan.nextInt(); // < 02. 14. 3 수치를 MAX_SIZE로 전환
//		
////		String[] orderMenuList = new String [3]; // < 02. 12. 3 수치를 MAX_SIZE로 전환 // < 02. 15. 3 수치를 MAX_SIZE로 전환
////		int[] orderPriceList = new int [3]; // > // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		String[] orderMenuList = new String [MAX_SIZE]; // < 02. 12. 3 수치를 MAX_SIZE로 전환 // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		int[] orderPriceList = new int [MAX_SIZE]; // > // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		
//		int count = 0;
//
//		
//		while(menuFlag) {
//			System.out.println("********************************************");
//			System.out.println("\t Welcome to Food Mart!!!");
//			System.out.println("********************************************");
//			System.out.println("\t 1. 음식 주문");
//			System.out.println("\t 2. 주문 조회");
//			System.out.println("\t 3. 음식 결제");
//			System.out.println("\t 9. 나가기");
//			System.out.println("********************************************");
//			System.out.println("\t Food Mart에 오신 것을 환영합니다.");
//			System.out.println("메뉴 >");
//			int menu = scan.nextInt();
//			
//			switch(menu){
//			case 1 : 
//				// 02. 2. 
////				System.out.println("=> 주문");
//				boolean orderFlag = true;
//				while(orderFlag) {
//					System.out.println("********************************************");
//					System.out.println("\t 1. 햄버거(🍔):1000원\t 2. 피자요(🍕):2000원");
//					System.out.println("\t 3. 라멘(🍜):3000원\t 4. 샐러드(🥗):4000원");
//					System.out.println("********************************************");
//					
//					System.out.print("주문 메뉴를 선택(숫자)해주세요. > ");
//					if(scan.hasNextInt()) {
//						int menuNo = scan.nextInt(); // 활용 범위 고려해 스코프 지정하기
//						
////						String menuName = null; // 가장 마지막에 주문한 하나만 저장됨
////						int menuPrice = 0;      // 02. 3. 에서 공용 배열 선언으로 이제 필요없음
//						
////						if (1 <= menuNo <= 4) { // < 02. 10.
//						if (1 <= menuNo && menuNo <= 4) {
//							orderMenuList[count] = menuList[menuNo-1];
//							orderPriceList[count] = priceList[menuNo-1];
//							
//							System.out.println("=> " + menuList[menuNo-1] + "주문 완료"); // 02. 11. 정상 주문일 경우만 표시되도록 아래에서 if 안으로 이동 처리
//						} else {
//							System.out.println("=> 메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
//						} // > 아래 코드와 위 코드는 동일한 기능을 함
//						
////						switch (menuNo) { // 주문 메뉴 선택 // 02. 5. 메뉴 정보 인덱스화, 6. 카운트처리 // < 02. 9. 똑같은 반복되는 코드는 줄일 수 없는지 고민
////							case 1:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 2:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 3:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 4:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							default: System.out.println("=> 메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
////						}//switch // >
//						
//						count++;
//						
//						// 02. 8. 주문 완료
//////						System.out.println("라멘 주문 완료");
////						System.out.println("=> " + menuList[menuNo-1] + "주문 완료");
//						
//						// 02. 7. 주문 개수 체크 (주문 리스트 저장 공간 O / count:3보다 작고, orderMenuList.length:3보다 작아야)
////						if(count == 3) { // < 02. 16. 3 수치를 MAX_SIZE로 전환
//						if(count == MAX_SIZE) {
////							System.out.println("=> 주문은 최대 3개까지 가능합니다.");
//							System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다."); // >
//							orderFlag = false;
//						} else {
//							// 02. 6. 계속 주문 여부 확인 추가
//							System.out.print("계속 주문하시겠습니까?(계속: 아무키나, 종료:n)");
//							if(scan.next().equals("n")) {
//								orderFlag = false; // 한번만 주문
//							}
//						}
//						
//					} else {
//						System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
//						scan.next();
//					}
//				} // while - menuNo
//				break;
//				
//			case 2 : 
////				System.out.println("=> 조회");
//				System.out.println("--------------------------------------------");
//				System.out.println("번호\t메뉴명\t\t가격");
//				System.out.println("--------------------------------------------");
//				if(count != 0) {
//					for(int i = 0; i < count; i++) {
//						System.out.print((i+1) + "\t");
//						System.out.print(orderMenuList[i] + "\t");
//						System.out.print(orderPriceList[i] + "\n");
//					}
//					System.out.println("--------------------------------------------");
//				} else {
//					System.out.println("=> 주문 내역이 없습니다.");
//				}
//				break;
//			case 3 : 
//				System.out.println("=> 결제");
//				break;
//			case 9 : 
//				System.out.println("=> -- 프로그램 종료 --");
//				System.exit(0);
//				break;
//			default :
//				System.out.println("=> 메뉴 준비중");
//			} // switch
//
//		} // while-menuFlag // 에러 체크 후에 다음 단위 구성, 에러 체크 후 다음 단위 구성으로 반복 진행

		
		
		
		
		
//		// 02. 1. 음식 주문 메뉴 구성
//		Scanner scan = new Scanner(System.in);
//		boolean menuFlag = true;
//		
//		// 02. 4. 주문 음식 리스트
//		String[] menuList = {"햄버거(🍔)", "피자요(🍕)", "라멘요(🍜)", "샐러드(🥗)"};
//		int[] priceList = {1000, 2000, 3000, 4000};
//
//		// 02. 3. 주문 리스트 선언 및 생성 
//		//        주문 기록이 반복문을 빠져나와도 기록이 유지되어야 하므로 밖에 배치
//		System.out.println("주문 리스트 크기 > "); // < 02. 13. 3 수치를 MAX_SIZE로 전환
//		final int MAX_SIZE = scan.nextInt(); // < 02. 14. 3 수치를 MAX_SIZE로 전환
//		
////		String[] orderMenuList = new String [3]; // < 02. 12. 3 수치를 MAX_SIZE로 전환 // < 02. 15. 3 수치를 MAX_SIZE로 전환
////		int[] orderPriceList = new int [3]; // > // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		String[] orderMenuList = new String [MAX_SIZE]; // < 02. 12. 3 수치를 MAX_SIZE로 전환 // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		int[] orderPriceList = new int [MAX_SIZE]; // > // < 02. 15. 3 수치를 MAX_SIZE로 전환
//		
//		int count = 0;
//
//		
//		while(menuFlag) {
//			System.out.println("********************************************");
//			System.out.println("\t Welcome to Food Mart!!!");
//			System.out.println("********************************************");
//			System.out.println("\t 1. 음식 주문");
//			System.out.println("\t 2. 주문 조회");
//			System.out.println("\t 3. 음식 결제");
//			System.out.println("\t 9. 나가기");
//			System.out.println("********************************************");
//			System.out.println("\t Food Mart에 오신 것을 환영합니다.");
//			System.out.print("메뉴 > ");
//			int menu = scan.nextInt();
//			
//			switch(menu){
//			case 1 : // 음식 주문
//				// 02. 2. 
////				System.out.println("=> 주문");
//				boolean orderFlag = true;
//				while(orderFlag) {
//					System.out.println("********************************************");
//					System.out.println("\t 1. 햄버거(🍔):1000원\t 2. 피자요(🍕):2000원");
//					System.out.println("\t 3. 라멘(🍜):3000원\t 4. 샐러드(🥗):4000원");
//					System.out.println("********************************************");
//					
//					System.out.print("주문 메뉴를 선택(숫자)해주세요. > ");
//					if(scan.hasNextInt()) {
//						int menuNo = scan.nextInt(); // 활용 범위 고려해 스코프 지정하기
//						
////						String menuName = null; // 가장 마지막에 주문한 하나만 저장됨
////						int menuPrice = 0;      // 02. 3. 에서 공용 배열 선언으로 이제 필요없음
//						
////						if (1 <= menuNo <= 4) { // < 02. 10.
//						if (1 <= menuNo && menuNo <= 4) {
//							orderMenuList[count] = menuList[menuNo-1];
//							orderPriceList[count] = priceList[menuNo-1];
//							
//							System.out.println("=> " + menuList[menuNo-1] + "주문 완료"); // 02. 11. 정상 주문일 경우만 표시되도록 아래에서 if 안으로 이동 처리
//						} else {
//							System.out.println("=> 메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
//						} // > 아래 코드와 위 코드는 동일한 기능을 함
//						
////						switch (menuNo) { // 주문 메뉴 선택 // 02. 5. 메뉴 정보 인덱스화, 6. 카운트처리 // < 02. 9. 똑같은 반복되는 코드는 줄일 수 없는지 고민
////							case 1:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 2:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 3:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							case 4:
////								orderMenuList[count] = menuList[menuNo-1];
////								orderPriceList[count] = priceList[menuNo-1];
////								break;
////							default: System.out.println("=> 메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
////						}//switch // >
//						
//						count++;
//						
//						// 02. 8. 주문 완료
//////						System.out.println("라멘 주문 완료");
////						System.out.println("=> " + menuList[menuNo-1] + "주문 완료");
//						
//						// 02. 7. 주문 개수 체크 (주문 리스트 저장 공간 O / count:3보다 작고, orderMenuList.length:3보다 작아야)
////						if(count == 3) { // < 02. 16. 3 수치를 MAX_SIZE로 전환
//						if(count == MAX_SIZE) {
////							System.out.println("=> 주문은 최대 3개까지 가능합니다.");
//							System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다."); // >
//							orderFlag = false;
//						} else {
//							// 02. 6. 계속 주문 여부 확인 추가
//							System.out.print("계속 주문하시겠습니까?(계속: 아무키나, 종료:n) > ");
//							if(scan.next().equals("n")) {
//								orderFlag = false; // 한번만 주문
//							}
//						}
//						
//					} else {
//						System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
//						scan.next();
//					}
//				} // while - menuNo
//				break;
//				
//			case 2 : // 음식 주문 리스트
////				System.out.println("=> 조회");
//				System.out.println("--------------------------------------------");
//				System.out.println("번호\t메뉴명\t\t가격");
//				System.out.println("--------------------------------------------");
//				if(count != 0) {
//					for(int i = 0; i < count; i++) {
//						System.out.print((i+1) + "\t");
//						System.out.print(orderMenuList[i] + "\t");
//						System.out.print(orderPriceList[i] + "\n");
//					}
//					System.out.println("--------------------------------------------");
//				} else {
//					System.out.println("=> 주문 내역이 없습니다.");
//				}
//				break;
//			case 3 : // 음식 결제
////				System.out.println("=> 결제");
//				boolean paymentFlag = true; // 03. 2
//				int charge = 0; // < 03. 05
//				int change = 0; // >
//				int totalPayment = 0; // 03. 7.
//				
//				for(int i = 0; i < count; i++) {
////						int totalPayment = orderPriceList[i]; // 가장 마지막 값만 불러옴
//					totalPayment += orderPriceList[i]; // 03. 3 누적 처리해도 for문 나가면 다시 0으로 초기화됨
//				}
//
//				while(paymentFlag) { // 03. 1. 결제 요금 부족시 반복 실행
//					// 결제 예정 금액 출력 : orderPriceList
//					// int count를 사용해도 되고, for 향상문 사용 가능
////					int totalPayment = 0; // 03. 4
//
//					System.out.println("=> 결제 예정 금액 : " + totalPayment);
//					System.out.print("결제할 요금을 입력(숫자)해주세요. >");
//					
//					if(scan.hasNextInt()) {
//						charge += scan.nextInt();
//						System.out.println("=> 총 입력 금액 : " + charge);
//						
//						if(charge >= totalPayment) {
//							change = charge - totalPayment;
//							paymentFlag = false;
//						} else {
//							System.out.println("=> 요금이 부족합니다, 다시 입력해 주세요.");
//						}
//						
//					} else {
//						System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
//						scan.next();
//					}//if
//				} // while
//				
//				System.out.println("=> 결제 완료");
//				
//				
//				// 결제 내역 리스트
//				System.out.println("--------------------------------------------"); // < 03. 6
//				System.out.println("\t음식 결제 내역");
//				System.out.println("--------------------------------------------");
//				System.out.println("메뉴명\t\t가격\t잔돈");
//				System.out.println("--------------------------------------------");
//				System.out.print(orderMenuList[0] + "등..\t");
//				System.out.print(totalPayment + "\t");
//				System.out.print(change + "\n");
//				System.out.println("--------------------------------------------"); // >
//				
//				// 주문 리스트(orderMenuList, orderPriceList) 초기화 // < 03. 8.
//				for(int i=0; i<count; i++) {
//					orderMenuList[i] = null;
//					orderPriceList[i] = 0;
//				}
//				orderMenuList = new String[MAX_SIZE]; // < 03. 9.
//				orderPriceList = new int[MAX_SIZE]; // >
//				
//				count--; // 추후에는 orderCount 등으로 세부화, 지금은 그냥 카운트 처리 // >
//				break;
//			case 9 : 
//				System.out.println("=> -- 프로그램 종료 --");
//				System.exit(0);
//				break;
//			default :
//				System.out.println("=> 메뉴 준비중");
//			} // switch
//
//		} // while-menuFlag // 에러 체크 후에 다음 단위 구성, 에러 체크 후 다음 단위 구성으로 반복 진행

		
		
		
		
		
		// 트래킹 놓친 전체 코드
		
//		// 02. 1. 음식 주문 메뉴 구성
//		Scanner scan = new Scanner(System.in);
//		boolean menuFlag = true;
//		
//		// 02. 4. 주문 음식 리스트
//		String[] menuList = {"햄버거(🍔)", "피자요(🍕)", "라멘요(🍜)", "샐러드(🥗)"};
//		int[] priceList = {1000, 2000, 3000, 4000};
//
//		// 02. 3. 주문 리스트 선언 및 생성
//		System.out.println("주문 리스트 크기 > ");
//		final int MAX_SIZE = scan.nextInt();
//		
//		String[] orderMenuList = new String [MAX_SIZE];
//		int[] orderPriceList = new int [MAX_SIZE];
//		
//		int orderCount = 0;
//		int paymentCount = 0;
//		
//		// 결제 리스트 선언 및 생성 // 우선 1차원 구축 후 2차원으로 전환
//		// 메뉴명, 결제금액, 입금액, 잔돈
//		String[] PayementMenuList = new String [MAX_SIZE]; // 결제금액
//		int[] totalAmountList = new int [MAX_SIZE];        // 입금액
//		int[] paidAmountList = new int [MAX_SIZE];         // 지불액
//		int[] changeList = new int [MAX_SIZE];             // 잔돈
//		
//		while(menuFlag) {
//			System.out.println("********************************************");
//			System.out.println("\t Welcome to Food Mart!!!");
//			System.out.println("********************************************");
//			System.out.println("\t 1. 음식 주문");
//			System.out.println("\t 2. 주문 조회");
//			System.out.println("\t 3. 음식 결제");
//			System.out.println("\t 4. 결제 조회");
//			System.out.println("\t 9. 나가기");
//			System.out.println("********************************************");
//			System.out.println("\t Food Mart에 오신 것을 환영합니다.");
//			System.out.print("메뉴 > ");
//			int menu = scan.nextInt();
//			
//			switch(menu){
//			case 1 : // 음식 주문
//				boolean orderFlag = true;
//				while(orderFlag) {
//					System.out.println("********************************************");
//					System.out.println("\t 1. 햄버거(🍔):1000원\t 2. 피자요(🍕):2000원");
//					System.out.println("\t 3. 라멘(🍜):3000원\t 4. 샐러드(🥗):4000원");
//					System.out.println("********************************************");
//					
//					System.out.print("주문 메뉴를 선택(숫자)해주세요. > ");
//					if(scan.hasNextInt()) {
//						int menuNo = scan.nextInt();
//						if(orderCount < MAX_SIZE) {
//							if (1 <= menuNo && menuNo <= 4) {
//								orderMenuList[orderCount] = menuList[menuNo-1];
//								orderPriceList[orderCount] = priceList[menuNo-1];
//
//								orderCount++;
//								System.out.println("=> " + menuList[menuNo-1] + "주문 완료");
//							} else {
//								System.out.println("=> 메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
//							}
//							if(orderCount == MAX_SIZE) {
//								System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다."); // >
//								orderFlag = false;
//							} else {
//								System.out.print("계속 주문하시겠습니까?(계속: 아무키나, 종료:n) > ");
//								if(scan.next().equals("n")) {
//									orderFlag = false;
//								}
//							}
//						} else {
//							System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능합니다."); // >
//							orderFlag = false;
//						}
//					} else {
//						System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
//						scan.next();
//					}
//				} // while - menuNo
//				break;
//				
//			case 2 : // 주문 조회
//				System.out.println("--------------------------------------------");
//				System.out.println("결제내역\t\t가격");
//				System.out.println("--------------------------------------------");
//				if(orderCount != 0) {
//					for(int i = 0; i < orderCount; i++) {
//						System.out.print((i+1) + "\t");
//						System.out.print(orderMenuList[i] + "\t");
//						System.out.print(orderPriceList[i] + "\n");
//					}
//					System.out.println("--------------------------------------------");
//				} else {
//					System.out.println("=> 주문 내역이 없습니다.");
//				}
//				break;
//			case 3 : // 음식 결제
//				boolean paymentFlag = true;
//				int charge = 0;
//				int change = 0;
//				int totalPayment = 0;
//				
//				for(int i = 0; i < orderCount; i++) {
//					totalPayment += orderPriceList[i];
//				}
//
//				while(paymentFlag) {
//					System.out.println("=> 결제 예정 금액 : " + totalPayment);
//					System.out.print("결제할 요금을 입력(숫자)해주세요. >");
//					
//					if(scan.hasNextInt()) {
//						charge += scan.nextInt();
//						System.out.println("=> 총 입력 금액 : " + charge);
//						
//						if(charge >= totalPayment) {
//							change = charge - totalPayment;
//							paymentFlag = false;
//						} else {
//							System.out.println("=> 요금이 부족합니다, 다시 입력해 주세요.");
//						}
//						
//					} else {
//						System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
//						scan.next();
//					}//if
//				} // while
//				
//				System.out.println("=> 결제 완료");
//
//				PayementMenuList[paymentCount] = orderMenuList[0] + "등.."; // 결제금액
//				totalAmountList[paymentCount] = totalPayment;               // 입금액
//				paidAmountList[paymentCount] = charge;                      // 지불액
//				changeList[paymentCount] = change;                          // 잔돈
//				
//				// 결제 내역
//				System.out.println("--------------------------------------------");
//				System.out.println("\t음식 결제 내역");
//				System.out.println("--------------------------------------------");
//				System.out.println("메뉴명\t\t음식금액\t결제금액\t잔돈");
//				System.out.println("--------------------------------------------");
//				System.out.print(PayementMenuList[paymentCount] + "\t");
//				System.out.print(totalAmountList[paymentCount] + "\t");
//				System.out.print(paidAmountList[paymentCount] + "\t");
//				System.out.print(changeList[paymentCount] + "\n");
//				System.out.println("--------------------------------------------");
//				
//				// 주문 리스트(orderMenuList, orderPriceList) 초기화
//				for(int i=0; i<orderCount; i++) {
//					orderMenuList[i] = null;
//					orderPriceList[i] = 0;
//				}
//				
//				orderCount--;
//				paymentCount++;
//				break;
//			case 4 : // 결제 조회
//				if(paymentCount != 0) {
//					System.out.println("--------------------------------------------");
//					System.out.println("\t이전 음식 결제 내역");
//					System.out.println("--------------------------------------------");
//					System.out.println("번호\t메뉴명\t결제금액\t입금액\t잔돈");
//					System.out.println("--------------------------------------------");
//					for(int i=0; i<paymentCount;i++) {
//						System.out.print((i+1) + " ");
//						System.out.print(PayementMenuList[i] + "\t");
//						System.out.print(totalAmountList[i] + "\t");
//						System.out.print(paidAmountList[i] + "\t");
//						System.out.print(changeList[i] + "\n");
//						System.out.println("--------------------------------------------");
//					}
//				} else {
//					System.out.println("=> 결제 내역이 없습니다.");
//				}
//				break;
//			case 9 : // 프로그램 종료
//				System.out.println("=> -- 프로그램 종료 --");
//				System.exit(0);
//				break;
//			default :
//				System.out.println("=> 메뉴 준비중");
//			} // switch
//
//		} // while-menuFlag // 에러 체크 후에 다음 단위 구성, 에러 체크 후 다음 단위 구성으로 반복 진행
		
		
		
		
		
		
		// 내 작성 내용과 강사님이 알려주신 방법으로 재구성한 코드
		
		// 02. 1. 음식 주문 메뉴 구성
		Scanner scan = new Scanner(System.in);
		boolean menuFlag = true;

		// 주문 음식 리스트
		String[] menuList = {"햄버거(🍔)", "피자요(🍕)", "라멘요(🍜)", "샐러드(🥗)"};
		int[] priceList = {100, 200, 300, 400};

		// 주문 리스트 선언 및 생성
		System.out.print("주문 리스트 크기> ");
		final int MAX_SIZE = scan.nextInt();
		String[] orderMenuList = new String[MAX_SIZE];
		int[] orderPriceList = new int[MAX_SIZE];
		int count = 0;

		// 결제 리스트 선언 및 생성
		String[] paymentMenuList = new String[MAX_SIZE];   // 결제메뉴
		int[] totalAmountList  = new int[MAX_SIZE];        // 결제금액
		int[] paidAmountList   = new int[MAX_SIZE];        // 입금액
		int[] changeList       = new int[MAX_SIZE];        // 잔돈
		int paymentCount = 0;

		while (menuFlag) {
		    System.out.println("******************************************");
		    System.out.println("\t Welcome to Food Mart!!!");
		    System.out.println("******************************************");
		    System.out.println("\t 1. 음식 주문");
		    System.out.println("\t 2. 주문 내역");
		    System.out.println("\t 3. 음식 결제");
		    System.out.println("\t 4. 결제 내역");
		    System.out.println("\t 9. 프로그램 종료");
		    System.out.println("******************************************");
		    System.out.println("***** Food Mart에 오신 것을 환영합니다");
		    System.out.print("메뉴> ");
		    int menu = scan.nextInt();

		    switch (menu) {
		        case 1:  // 음식 주문
		            boolean orderFlag = true;
		            while (orderFlag) {
		                System.out.println("******************************************");
		                System.out.println("\t 1. 햄버거(🍔):100\t 2. 피자(🍕):200");
		                System.out.println("\t 3. 라멘(🍜):300\t 4. 샐러드(🥗):400");
		                System.out.println("******************************************");
		                System.out.print("주문 메뉴(숫자로)> ");
		                if (scan.hasNextInt()) {
		                    int menuNo = scan.nextInt();
		                    if (1 <= menuNo && menuNo <= 4) {
		                        orderMenuList[count] = menuList[menuNo - 1];
		                        orderPriceList[count] = priceList[menuNo - 1];
		                        count++;
		                        System.out.println("=> " + menuList[menuNo - 1] + " 주문 완료!!");
		                    } else {
		                        System.out.println("=> 메뉴 준비중 입니다.");
		                    }
		                    // 주문 갯수 체크
		                    if (count == MAX_SIZE) {
		                        System.out.println("=> 주문은 최대 " + MAX_SIZE + "개까지 가능!!");
		                        orderFlag = false;
		                    } else {
		                        System.out.print("계속 주문?(계속:아무키나, 종료:n)> ");
		                        if (scan.next().equals("n")) {
		                            orderFlag = false;
		                        }
		                    }
		                } else {
		                    System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요");
		                    scan.next();
		                }
		            } // while - orderFlag
		            break;

		        case 2: // 음식 주문 리스트
		            if (count != 0) {
		                System.out.println("-----------------------------------------");
		                System.out.println("\t음식 주문 리스트");
		                System.out.println("-----------------------------------------");
		                System.out.println("번호\t메뉴명\t가격");
		                System.out.println("-----------------------------------------");
		                for (int i = 0; i < count; i++) {
		                    System.out.print((i + 1) + "\t");
		                    System.out.print(orderMenuList[i] + "\t");
		                    System.out.print(orderPriceList[i] + "\n");
		                }
		                System.out.println("-----------------------------------------");
		            } else {
		                System.out.println("=> 주문 내역 없음!!");
		            }
		            break;

		        case 3: // 음식 결제
		            if (count != 0) {
		                boolean paymentFlag = true;
		                int charge = 0;
		                int change = 0;
		                int totalPayment = 0;
		                for (int i = 0; i < count; i++) {
		                    totalPayment += orderPriceList[i];
		                }
		                while (paymentFlag) { // 결제 요금 부족시 반복 실행
		                    System.out.println("=> 결제 예정 금액 : " + totalPayment);
		                    System.out.print("결제할 요금 입력(숫자)> ");
		                    if (scan.hasNextInt()) {
		                        charge += scan.nextInt();
		                        System.out.println("=> 총 입력 금액 : " + charge);
		                        if (charge >= totalPayment) {
		                            change = charge - totalPayment;
		                            paymentFlag = false;
		                        } else {
		                            System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요");
		                        }
		                    } else {
		                        System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
		                        scan.next();
		                    }
		                } // while - paymentFlag

		                paymentMenuList[paymentCount] = orderMenuList[0] + " 등..";
		                totalAmountList[paymentCount] = totalPayment;
		                paidAmountList[paymentCount] = charge;
		                changeList[paymentCount] = change;

		                System.out.println("=> 결제 완료");
		                System.out.println("-----------------------------------------");
		                System.out.println("주문메뉴\t결제금액\t입금액\t잔돈");
		                System.out.println("-----------------------------------------");
		                System.out.print(paymentMenuList[paymentCount] + "\t");
		                System.out.print(totalAmountList[paymentCount] + "\t");
		                System.out.print(paidAmountList[paymentCount] + "\t");
		                System.out.print(changeList[paymentCount] + "\n");
		                System.out.println("-----------------------------------------");

		                // orderMenuList, orderPriceList 초기화
		                for (int i = 0; i < count; i++) {
		                    orderMenuList[i] = null;
		                    orderPriceList[i] = 0;
		                }

		                count = 0;            // 주문 카운트 초기화
		                paymentCount++;       // 결제 카운트 증가
		            } else {
		                System.out.println("=> 주문 메뉴 없음!!");
		            }
		            break;

		        case 4: // 결제 내역
		            if (paymentCount != 0) {
		                System.out.println("-----------------------------------------");
		                System.out.println("\t결제 내역");
		                System.out.println("-----------------------------------------");
		                System.out.println("번호\t주문메뉴\t결제금액\t입금액\t잔돈");
		                System.out.println("-----------------------------------------");
		                for (int i = 0; i < paymentCount; i++) {
		                    System.out.print((i + 1) + "\t");
		                    System.out.print(paymentMenuList[i] + "\t");
		                    System.out.print(totalAmountList[i] + "\t");
		                    System.out.print(paidAmountList[i] + "\t");
		                    System.out.print(changeList[i] + "\n");
		                }
		                System.out.println("-----------------------------------------");
		            } else {
		                System.out.println("=> 결제내역 없음!!");
		            }
		            break;

		        case 9:
		            System.out.println("-- 프로그램 종료 --");
		            System.exit(0);
		            break;

		        default:
		            System.out.println("=> 메뉴 준비중!!");
		    } // switch

		} // while - menuFlag

	} // main
}


