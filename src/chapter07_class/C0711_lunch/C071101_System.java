package chapter07_class.C0711_lunch;

import java.util.Scanner;

public class C071101_System {
	
	// Field
	Scanner scan;
	C071106_LunchOrderMenuManager menuManager;
	
	String[] lunchMenuNames = {"햄버거(🍔)", "피자요(🍕) ", "라멘요(🍜)", "샐러드(🥗)"}; // < 05. 02. 데이터 정립
	int[] lunchMenuPrices = {100, 200, 300, 400}; // 05. 02. >
	C071103_LunchMenu[] lunchMenuList;
	C071104_LunchOrderItem[] orderItemList;
	C071105_LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0; // 결제금액 - 사용자 입력
	int change = 0; // 잔돈
	String title;
	
	// Constructor
	public C071101_System() {
		scan = new Scanner(System.in);
//		menuManager = new JAVA0709LOrderSOOP06LunchOrderMenuManager(lunchMenuNames, lunchMenuPrices);
		menuManager = new C071106_LunchOrderMenuManager(this);
		lunchMenuList = new C071103_LunchMenu[4];
		orderItemList = new C071104_LunchOrderItem[4];
		
		menuManager.createLunchMenu(); // 런치 메뉴 생성 메소드 호출
//		showMainMenu();
	}
	
	public C071101_System(String title) {
		this.title = title;
		scan = new Scanner(System.in);
//		menuManager = new JAVA0709LOrderSOOP06LunchOrderMenuManager(lunchMenuNames, lunchMenuPrices);
		menuManager = new C071106_LunchOrderMenuManager(this);
		lunchMenuList = new C071103_LunchMenu[4];
		orderItemList = new C071104_LunchOrderItem[4];
		
		menuManager.createLunchMenu(); // 런치 메뉴 생성 메소드 호출
		menuManager.showMainMenu();
	}
	
	// Mathod
	// 04. 01. 메뉴 틀 구성
	
	/*
	 * 주문 아이템의 인덱스 검색
	 */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for (int i = 0; i < orderCount; i++ ) {
			C071104_LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		
		return idx;
	}
	
	/*
	 * 13. 주문리스트 초기화
	 */
	public void orderItemListInit() {
//		orderItemList = new JAVA0709LOrderSOOP04LunchOrderItem[4];
		
//		for(int i = 0; i < orderCount; i++) {
//			orderItemList[i] = null;
//		}
		for(C071104_LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) orderItem = null;
		}
	    orderCount = 0;
	}
	
	/*
	 * 09. 음식 주문 : order()
	 */
	public void order(int lunchMenu) {
		// lunchMenuList의 메뉴 번호 확인
		for(C071103_LunchMenu menu : lunchMenuList) {
			if(menu.no == lunchMenu) {
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount] = new C071104_LunchOrderItem();
					
					orderItemList[orderCount].no = menu.no;
					orderItemList[orderCount].name = menu.name;
					orderItemList[orderCount].price = menu.price;
					orderItemList[orderCount].qty = 1;
					orderCount++;
				} else {
					orderItemList[idx].qty += 1;
				}
			}
		}
		
		System.out.println(lunchMenu + "=> 주문이 완료되었습니다.");
		menuManager.showMainMenu();
	}
	
	// 08. 주문 내역 출력
	
	/*
	 * 주문 내역 : orderList()
	 */
	public void orderList() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역이 존재하지 않습니다, 음식을 주문해주세요.");
		} else {
            System.out.println("-----------------------------------------");
            System.out.println("\t음식 주문 리스트");
            System.out.println("-----------------------------------------");
            System.out.println("번호\t메뉴명\t\t가격\t수량");
            System.out.println("-----------------------------------------");
            for (C071104_LunchOrderItem orderItem : orderItemList) {
            	if(orderItem != null) {
            		System.out.print(orderItem.no + "\t");
            		System.out.print(orderItem.name + "\t");
            		System.out.print(orderItem.price + "\t");
            		System.out.print(orderItem.qty + "\n");
            	}
            }
            System.out.println("-----------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
	// 10. 
	
	/*
	 * 결제 예정 금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for(C071104_LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) {
				sum += orderItem.price * orderItem.qty;
			}
		}
		return sum;
	}
	
	// 11. 
	
	/*
	 * 음식 결제 : payment() - LunchPaymentItem
	 */
	public void payment() {
		if(orderCount == 0) {
			System.out.println("=> 주문내역이 존재하지 않습니다, 음식을 주문해주세요.");
		} else {
			int total = totalPayment();
            System.out.println("=> 결제 예정 금액 : " + total);
            System.out.print("결제할 요금 입력(숫자) > ");
            if (scan.hasNextInt()) {
                amount += scan.nextInt();
                System.out.println("=> 총 입력 금액 : " + amount);
                if (amount >= total) {
                    change = amount - total;
                    System.out.println("=> 결제가 정상적으로 완료되었습니다.");
                    paymentItem = new C071105_LunchPaymentItem();
                    paymentItem.name = orderItemList[0].name + "등..";
                    paymentItem.totalPayment = total;
                    paymentItem.amount = amount;
                    paymentItem.change = change;
                    
                    // 주문리스트 초기화
                    orderItemListInit();
                } else {
                    System.out.println("=> 요금이 부족합니다. 다시 입력해 주세요.");
                    payment();
                }
            } else {
                System.out.println("=> 올바르지 않은 입력값입니다. 다시 입력해주세요.");
                scan.next();
            }
		}
		menuManager.showMainMenu();
	}
	
	/*
	 * 12. 결제 내역 : paymentList()
	 */
	public void paymentList() {
		if(paymentItem == null) {
			System.out.println("=> 결제내역이 존재하지 않습니다, 주문을 진행해주세요.");
		} else {
            System.out.println("-----------------------------------------");
            System.out.println("\t결제 내역");
            System.out.println("-----------------------------------------");
            System.out.println("주문명\t\t결제금액\t총입금액\t잔돈");
            System.out.println("-----------------------------------------");
    		System.out.print(paymentItem.name + "\t");
    		System.out.print(paymentItem.totalPayment + "\t");
    		System.out.print(paymentItem.amount + "\t");
    		System.out.print(paymentItem.change + "\n");
            System.out.println("-----------------------------------------");
		}
		menuManager.showMainMenu();
	}
	
	/*
	 * 프로그램 종료
	 */

}