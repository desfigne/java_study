package c05_controlstatements; // 패키지명 선언

import java.util.Scanner; // Scanner 클래스 import

public class C0507_OrderDrink_V01 { // 클래스 선언

	public static void main(String[] args) { // main 메서드 시작
		// Step 0 : main 안의 지역 변수 선언
		Scanner scan = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		int menuNo = 0, menuPrice = 0, payPrice = 0, payLeft = 0; // 메뉴번호, 메뉴가격, 누적 지불금액, 잔액 변수 선언
		String menuName = "", menuPriceOutput = ""; // 메뉴명, 출력용 가격 변수 선언
		boolean menuFlag = true, payFlag = true; // 메뉴 선택 및 결제 루프 제어용 플래그
		
		// Step 1 : 메뉴판 출력
		System.out.println("[시작]"); // 프로그램 시작 알림
		System.out.println("========================================="); // 구분선
		System.out.println(""); // 줄바꿈
		System.out.println("\t\t 메 뉴 판"); // 메뉴판 제목
		System.out.println(""); // 줄바꿈
		System.out.println("========================================="); // 구분선
		System.out.println(""); // 줄바꿈
		System.out.println("\t1. ☕ 아메리카노  - 2,800원"); // 메뉴 1
		System.out.println("-----------------------------------------"); // 구분선
		System.out.println("\t2. 🍵 바닐라 라떼 - 3,500원"); // 메뉴 2
		System.out.println("-----------------------------------------"); // 구분선
		System.out.println("\t3. 🥤 딸기 쉐이크 - 4,000원"); // 메뉴 3
		System.out.println(""); // 줄바꿈
		System.out.println("========================================="); // 구분선
		System.out.println(""); // 줄바꿈
		System.out.println("음료를 주문하시려면 번호를 입력해주세요."); // 사용자 안내
		
		// Step 2 : 메뉴 주문 기능 (메뉴 선택 루프)
		while(menuFlag) { // 메뉴를 올바르게 선택할 때까지 반복
			System.out.println("주문할 메뉴 번호 입력 > "); // 사용자에게 메뉴 번호 입력 요청
			if(scan.hasNextInt()) { // 입력값이 정수인지 체크
				menuFlag = false; // 정상 입력시 루프 종료 준비
				menuNo = scan.nextInt(); // 입력값을 menuNo에 저장
				
				switch(menuNo) { // 입력번호에 따라 메뉴명과 가격 결정
					case 1 : menuName = " 1. ☕ 아메리카노";  menuPrice = 2800; break; // 1번 메뉴
					case 2 : menuName = " 2. 🍵 바닐라 라떼"; menuPrice = 3500; break; // 2번 메뉴
					case 3 : menuName = " 3. 🥤 딸기 쉐이크"; menuPrice = 4000; break; // 3번 메뉴
					default : System.out.println("준비 중입니다."); // 잘못된 번호 입력 시 안내
					menuFlag = true; // 잘못된 입력이면 루프 계속
				}
				menuPriceOutput = String.format("%,d",  new Object[] {Integer.valueOf(menuPrice)}); // 메뉴가격을 천단위 콤마로 포맷팅하여 저장
			} else { // 입력값이 정수가 아닌 경우
				System.out.println("준비 중입니다."); // 안내 메시지
				scan.next(); // 잘못된 입력값(문자 등) 소진
			}
		} // 메뉴 선택 루프 종료
		System.out.println("-- 주문 종료, 결제 시작 --"); // 주문 완료 안내
		System.out.println("주문 메뉴 " + menuName + " - 결제 금액 " + menuPriceOutput + "원"); // 주문 내역 출력
		
		// Step 3 : 결제 기능 (결제 금액 입력 루프)
		while(payFlag) { // 결제가 완료될 때까지 반복
			System.out.println("결제할 금액 입력 > "); // 사용자에게 결제할 금액 입력 요청
			
			if(scan.hasNextInt()) { // 입력값이 정수인지 체크
				payPrice += scan.nextInt(); // 입력값을 누적 지불금액(payPrice)에 더함
				System.out.println("총 입력 금액 > " + payPrice); // 현재까지 누적된 지불금액 출력
				
				if(payPrice >= menuPrice) { // 누적 지불금액이 메뉴가격 이상이면
					payLeft = payPrice - menuPrice; // 잔액(거스름돈) 계산
					payFlag = false; // 결제 루프 종료 준비
					System.out.println("결제 완료! 지불 금액은 " + payPrice + "원, 결제 잔액은 " + payLeft + "원"); // 결제 완료 안내
				} else {
					System.out.println("지불 금액이 부족합니다, 결제를 다시 시도해주세요."); // 부족 안내
				}
			} else {
				System.out.println("입력 금액이 올바르지 않습니다, 다시 시도해주세요."); // 잘못된 입력 안내
				scan.next(); // 잘못된 입력값 소진
			}
			System.out.println("-- 결제 종료, 내역 시작 --"); // 결제 시도 후 내역 시작 안내 (루프 내 반복 출력)
		} // 결제 루프 종료
		
		// Step 4 : 주문 완료
		System.out.println("이용해주셔서 감사합니다."); // 전체 주문 및 결제 완료 안내
		
	} // main 종료

} // class 종료
