package c05_controlstatements;

import java.util.Scanner;

public class C0508_OrderLunch_V01 {

	public static void main(String[] args) {
		// 메뉴판
		System.out.println("********************************************");
		System.out.println("\t Welcome to Food Mart!!!");
		System.out.println("********************************************");
		System.out.println("\t 1. 햄버거(🍔):100원\t 2. 피자(🍕):200원");
		System.out.println("\t 3. 라멘(🍜):300원\t 4. 샐러드(🥗):400원");
		System.out.println("\t 9. 나가기");
		System.out.println("********************************************");
		
		Scanner scan = new Scanner(System.in);
		int menuNo = -1;
		String menuName = "";
		int menuPrice = 0;
		int charge = 0;
		int change = 0;
		
		// 1. 메뉴 선택
		System.out.println("메뉴를 선택(숫자)해주세요. > ");
		if(scan.hasNextInt()) {
			menuNo = scan.nextInt();
			
			switch (menuNo) {
				case 1: menuName = "햄버거(🍔)"; menuPrice = 100; break;
				case 2: menuName = "피자(🍕)"; menuPrice = 200; break;
				case 3: menuName = "라멘(🍜)"; menuPrice = 300; break;
				case 4: menuName = "샐러드(🥗)"; menuPrice = 400; break;
//				case 1: System.out.println("햄버거(🍔)"); break;
//				case 2: System.out.println("피자(🍕)"); break;
//				case 3: System.out.println("라멘(🍜)"); break;
//				case 4: System.out.println("샐러드(🥗)"); break;
				case 9:
					System.out.println("이용해주셔서 감사합니다. 다음에 또 뵙기를 희망합니다.\n- 프로그램 종료 -");
					System.exit(0);
					break;
				default: System.out.println("메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
			}//switch
			
//			if(menuNo == 1) {
//				System.out.println("햄버거(🍔)");
//			} else if(menuNo == 2) {
//				System.out.println("피자(🍕)");
//			} else if(menuNo == 3) {
//				System.out.println("라멘(🍜)");
//			} else if(menuNo == 4) {
//				System.out.println("샐러드(🥗)");
//			} else if(menuNo == 9) {
//				System.out.println("이용해주셔서 감사합니다. 다음에 또 뵙기를 희망합니다.\n- 프로그램 종료 -");
//				System.exit(0);
//			} else {
//				System.out.println("메뉴가 준비중입니다. 표시된 메뉴의 번호를 입력해주세요.");
//			}
			
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}
		System.out.println("주문하신 메뉴는 " + menuName + ", 가격은 " + menuPrice + "원입니다.");
		
		// 2. 주문 메뉴 결제
//		int charge = 0; 최상위로 이동
//		int change = 0; 최상위로 이동
		
		System.out.println("결제할 요금을 입력(숫자)해주세요. >");
		
		if(scan.hasNextInt()) {
			charge = scan.nextInt();
			
			if(charge >= menuPrice) {
				change = charge - menuPrice;
			} else {
				System.out.println("요금이 부족합니다, 다시 입력해 주세요.");
			}
			
		} else {
			System.out.println("올바르지 않은 입력값입니다.");
		}//if
		
		// 3. 주문 내역 출력 : 주문한 메뉴는 (햄버거), 결제금액(), 잔돈() 입니다.
		System.out.println("주문한 메뉴는 " + menuName + ", 결제금액(" + menuPrice + "), 잔돈(" + change + ") 입니다.");
	}
}
