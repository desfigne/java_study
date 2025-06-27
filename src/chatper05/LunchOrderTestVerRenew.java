package chatper05;

import java.util.Scanner;

public class LunchOrderTestVerRenew {

	public static void main(String[] args) {
		// 메뉴판
		System.out.println("********************************************");
		System.out.println("\t Welcome to Food Mart!!!");
		System.out.println("********************************************");
		System.out.println("\t 1. 햄버거(🍔):100원\t 2. 피자(🍕):200원");
		System.out.println("\t 3. 라멘(🍜):300원\t 4. 샐러드(🥗):400원");
		System.out.println("\t 9. 나가기");
		System.out.println("********************************************");
		
		Scanner scan = new Scanner(System.in); // 입력창 기능 로드
		int menuNo = -1; // 메뉴 번호 디폴트 선언
		String menuName = ""; // 메뉴 이름 선언
		int menuPrice = 0;// 메뉴 금액 선언
		int payCash = 0;  // 지불 금액 선언
		int leftCash = 0; // 잔액 선언
		
		// 1. 메뉴 선택
		System.out.println("원하시는 메뉴의 번호를 입력해주세요 > "); // 메뉴 입력 안내
		if(scan.hasNextInt()) { // 만약 정수일 경우 진입
			menuNo = scan.nextInt(); // 메뉴 번호 스캔
			
			switch (menuNo) {
				case 1: menuName = "1. 햄버거(🍔)"; menuPrice = 100; break;
				case 2: menuName = "2. 피자(🍕)"; menuPrice = 100; break;
				case 3: menuName = "3. 라멘(🍜)"; menuPrice = 100; break;
				case 4: menuName = "4. 샐러드(🥗)"; menuPrice = 100; break;
				case 9: 
					System.out.println("- 프로그램 종료 -\n 이용해주셔서 감사합니다.");
					System.exit(0);
					break;
				default:
					System.out.println("현재 준비된 메뉴 외의 다른 메뉴는 준비중입니다.");
			}
		} else { // 정수가 아닌 다른 입력값일 경우 진입
			System.out.println("메뉴에 등록된 번호를 입력해주세요."); // 메뉴 번호로만 입력 안내
		}
		System.out.println("선택하신 메뉴는 " + menuName + "이며 결제가 필요한 금액은 " + menuPrice + "원입니다."); // 선택된 메뉴 안내
		
		// 2. 주문 메뉴 결제
//		int charge = 0; 최상위로 이동
//		int change = 0; 최상위로 이동
		
		System.out.println("지불할 금액을 입력해주세요. > "); // 결제 금액 입력 안내
		
		if(scan.hasNextInt()) { // 입력한 금액이 정수값일 경우 진입
			payCash = scan.nextInt(); // 1. 지불한 금액을 불러옴
			
			if(payCash >= menuPrice) { // 2. 지불한 금액이 메뉴 금액보다 클 경우 진입
				leftCash = payCash - menuPrice;
			} else { // 3. 지불한 금액이 메뉴 금액보다 작을 경우 진입
				System.out.println("지불한 금액이 부족합니다."); // 부족한 결제 금액 안내
				
			}
		} else { // 정수가 아닌 다른 입력값일 경우 진입
			System.out.println("결제될 금액을 입력해주세요."); // 결제 금액으로만 입력 안내
		}
		
		// 3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		System.out.println("주문하신 내역 : " + menuName + " / 지불 금액 " + payCash + "원, 주문 금액 " + menuPrice + "원, 결제 후 잔액은 " + leftCash + "원입니다."); // 지불 금액 - 메뉴 가격 = 잔액 계산 후 화면 표시
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
