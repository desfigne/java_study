package chatper05;

import java.util.Scanner;

public class DrinkOrderTestVer1 {

	public static void main(String[] args) {
		// Step 0 : main 안의 지역 변수 선언
		Scanner scan = new Scanner(System.in); // 입력창 선언
		int menuNo = 0, menuPrice = 0, payPrice = 0, payLeft = 0; // 번호, 금액(메뉴, 지불, 잔액) 선언
		String menuName = "", menuPriceOutput = "";
		boolean menuFlag = true, payFlag = true;
		
		// Step 1 : 메뉴판 출력
		System.out.println("[시작]");
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("\t\t 메 뉴 판");
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("\t1. ☕ 아메리카노  - 2,800원");
		System.out.println("-----------------------------------------");
		System.out.println("\t2. 🍵 바닐라 라떼 - 3,500원");
		System.out.println("-----------------------------------------");
		System.out.println("\t3. 🥤 딸기 쉐이크 - 4,000원");
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("음료를 주문하시려면 번호를 입력해주세요.");
		
		// Step 2 : 메뉴 주문 기능
		while(menuFlag) {
			System.out.println("주문할 메뉴 번호 입력 > ");
			if(scan.hasNextInt()) { // 입력 정상일 경우 진입
				menuFlag = false; // 위에나 아래에 기능 코드 모두 실행 가능
				menuNo = scan.nextInt();// 선택 메뉴번호를 체크하여 메뉴명, 메뉴가격을 별도의 변수에 저장
				
				switch(menuNo) {
					case 1 : menuName = " 1. ☕ 아메리카노";  menuPrice = 2800; break;
					case 2 : menuName = " 2. 🍵 바닐라 라떼"; menuPrice = 3500; break;
					case 3 : menuName = " 3. 🥤 딸기 쉐이크"; menuPrice = 4000; break;
					default : System.out.println("준비 중입니다.");
					menuFlag = true;
				}
				
				menuPriceOutput = String.format("%,d",  new Object[] {Integer.valueOf(menuPrice)}); // 출력용 메뉴가격 저장
			} else { // 입력 비정상일 경우 진입
				System.out.println("준비 중입니다."); // 단일 사용 시 정체 발생
				scan.next(); // 문자를 입력 받으라는 명령
			}
		} // while
		System.out.println("-- 주문 종료, 결제 시작 --");
		System.out.println("주문 메뉴 " + menuName + " - 결제 금액 " + menuPriceOutput + "원");
		
		// Step 3 : 결제 기능
		while(payFlag) {
			System.out.println("결제할 금액 입력 > ");
			
			if(scan.hasNextInt()) {
				payPrice += scan.nextInt();
				System.out.println("총 입력 금액 > " + payPrice);
				
				if(payPrice >= menuPrice) {
					payLeft = payPrice - menuPrice;
					payFlag = false;
					System.out.println("결제 완료! 지불 금액은 " + payPrice + "원, 결제 잔액은 " + payLeft + "원");
				} else {
					System.out.println("지불 금액이 부족합니다, 결제를 다시 시도해주세요.");
				}
			} else {
				System.out.println("입력 금액이 올바르지 않습니다, 다시 시도해주세요.");
				scan.next();
			}
		}
		System.out.println("-- 결제 종료, 내역 시작 --");
		
		// Step 4 : 주문 완료
		System.out.println("이용해주셔서 감사합니다.");
		
	} // main

} // class
