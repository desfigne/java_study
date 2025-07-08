package chapter07;

import java.util.Scanner;

public class JAVA0707LOrderSOOP01System {
	
	// Field
	Scanner scan = new Scanner(System.in);
	
	String[] lunchMenuNames = {"햄버거(🍔)", "피자요(🍕) ", "라멘요(🍜)", "샐러드(🥗)"}; // < 05. 02. 데이터 정립
	int[] lunchMenuPrices = {100, 200, 300, 400}; // 05. 02. >
	JAVA0707LOrderSOOP03LunchMenu[] lunchMenuList = new JAVA0707LOrderSOOP03LunchMenu[4]; // 주문할 메뉴 : LunchMenu
	JAVA0707LOrderSOOP04LunchOrderItem[] orderItemList = new JAVA0707LOrderSOOP04LunchOrderItem[4];
	JAVA0707LOrderSOOP05LunchPaymentItem paymentItem;
	int orderCount = 0;
	int amount = 0; // 결제금액 - 사용자 입력
	int change = 0; // 잔돈
	
	
	// Constructor
	
	// Method
	/*
	 * 05. 런치 메뉴 생성
	 */
	public void createLunchMenu() {
	    for(int i = 0; i < lunchMenuNames.length; i++ ) {
	    	// 아래 코드가 for문 안에 있을 경우에는 정상 출력, for문 밖에 있을 경우 중복 내용으로 처리됨
	    	// for문 바깥에 놓게 되면 객체를 하나를 그대로(주소값 동일) 사용하게 되고, for문 안에 배치하면 객체를 1개씩 새로 생성(주소값 다름)해서 사용
	    	// 생성은 안에서 진행해야 함 예) for문 밖에 선언은 > LunchMenu menu = null; for문 안에 선언은 > menu = new LunchMenu();
	    	JAVA0707LOrderSOOP03LunchMenu menu = new JAVA0707LOrderSOOP03LunchMenu();
	    	//
	    	menu.no = i + 1;
	    	menu.name = lunchMenuNames[i];
	    	menu.price = lunchMenuPrices[i];
	    	
	    	lunchMenuList[i] = menu;
	    }
	}
    
    /*
     * 05. 02. 런치 메뉴 출력
     */
//    public void showLunchMenu() {
//    	int no = 1;
//    	System.out.println("******************************************");
//	    System.out.println("=> lunchMenuList");
//	    for (JAVA0708LOrderSOOP03LunchMenu menu2 : lunchMenuList) {
//	    	System.out.print(no + ".");
//	    	System.out.print(menu2.name + "\t");
//	    	System.out.print(menu2.price + "\n");
//	    	no++;
//	    	System.out.println("******************************************");
//	    }
//    }
    public void showLunchMenu() {
    	System.out.println("******************************************");
	    for (JAVA0707LOrderSOOP03LunchMenu menu : lunchMenuList) {
	    	System.out.print(menu.no + ".");
	    	System.out.print(menu.name + "\t");
	    	System.out.print(menu.price + "\n");
	    }
	    System.out.println("******************************************");
	    selectLunchMenu();
    }
	
	/* 
	 * 06. 런치 메뉴 선택
	 */
	// main menu check
	public void selectLunchMenu() {
	    System.out.print("주문 메뉴(숫자) > ");
	    
	    if(scan.hasNextInt()) {
	    	lunchMenuCheck(scan.nextInt());
	    } else {
	    	System.out.println("입력된 값이 바르지 않습니다, 다시 입력해주세요.");
	    	scan.next(); // 잘못된 값을 받지 않으면 버퍼에만 머무름
	    	selectMainMenu();
	    }
	}
	
	/* 
	 * 01. 메인 메뉴 출력
	 */
	public void showMainMenu() {
		System.out.println("\n******************************************");
	    System.out.println("\t Welcome to Food Mart!!!");
	    System.out.println("******************************************");
	    System.out.println("\t 1. 음식 주문");
	    System.out.println("\t 2. 주문 내역");
	    System.out.println("\t 3. 음식 결제");
	    System.out.println("\t 4. 결제 내역");
	    System.out.println("\t 9. 프로그램 종료");
	    System.out.println("******************************************");
	    System.out.println("***** Food Mart에 오신 것을 환영합니다.");
	    
	    createLunchMenu();
	    selectMainMenu();
	}
	
	/* 
	 * 03. 메인 메뉴 선택
	 */
	// main menu check
	public void selectMainMenu() {
	    System.out.print("메인 메뉴(숫자) > ");
	    
	    if(scan.hasNextInt()) {
	    	mainMenuCheck(scan.nextInt());
	    } else {
	    	System.out.println("입력된 값이 바르지 않습니다, 다시 입력해주세요.");
	    	scan.next(); // 잘못된 값을 받지 않으면 버퍼에만 머무름
	    	selectMainMenu();
	    }
	}
	
	/*
	 * 02. 메인 메뉴 체크
	 */
	// main menu check
	public void mainMenuCheck(int mainMenu) {
		switch(mainMenu) {
		case 1: showLunchMenu(); break; // 04. 02.  각 메뉴 호출
		case 2: orderList(); break;
		case 3: payment(); break;
		case 4: paymentList(); break;
		case 9: System.out.println(" => 음식 주문 시스템을 종료합니다.");
				System.exit(0); break;
		default: System.out.println(" => 메뉴를 준비중입니다.");
				 showMainMenu();
		}
	}
	
	/*
	 * 07. 런치 메뉴 체크
	 */
	// main menu check
	public void lunchMenuCheck(int lunchMenu) {
		// lunchMenu : 1~4 => 주문가능, 다른번호 : 메뉴 준비중 => 다시 입력 처리
		if (1 <= lunchMenu && lunchMenu <= 4) {
			// 주문 진행
			order(lunchMenu);
		} else {
			System.out.println("=> 런치 메뉴 준비중입니다, 다시 입력해주세요.");
			showLunchMenu();
		}
	}
	
	// 04. 01. 메뉴 틀 구성
	
	/*
	 * 주문 아이템의 인덱스 검색
	 */
	public int searchOrderItemIdx(int lunchMenu) {
		int idx = -1;
		for (int i = 0; i < orderCount; i++ ) {
			JAVA0707LOrderSOOP04LunchOrderItem orderItem = orderItemList[i];
			if(orderItem.no == lunchMenu) idx = i;
		}
		
		return idx;
	}
	
	/*
	 * 13. 주문리스트 초기화
	 */
	public void orderItemListInit() {
//		orderItemList = new JAVA0708LOrderSOOP04LunchOrderItem[4];
		
//		for(int i = 0; i < orderCount; i++) {
//			orderItemList[i] = null;
//		}
		for(JAVA0707LOrderSOOP04LunchOrderItem orderItem : orderItemList) {
			if(orderItem != null) orderItem = null;
		}
	    orderCount = 0;
	}
	
	/*
	 * 09. 음식 주문 : order()
	 */
	public void order(int lunchMenu) {
		// lunchMenuList의 메뉴 번호 확인
		for(JAVA0707LOrderSOOP03LunchMenu menu : lunchMenuList) {
			if(menu.no == lunchMenu) {
				int idx = searchOrderItemIdx(lunchMenu);
				if(idx == -1) {
					orderItemList[orderCount] = new JAVA0707LOrderSOOP04LunchOrderItem();
					
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
		showMainMenu();
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
            for (JAVA0707LOrderSOOP04LunchOrderItem orderItem : orderItemList) {
            	if(orderItem != null) {
            		System.out.print(orderItem.no + "\t");
            		System.out.print(orderItem.name + "\t");
            		System.out.print(orderItem.price + "\t");
            		System.out.print(orderItem.qty + "\n");
            	}
            }
            System.out.println("-----------------------------------------");
		}
		showMainMenu();
	}
	
	// 10. 
	
	/*
	 * 결제 예정 금액 산출
	 */
	public int totalPayment() {
		int sum = 0;
		for(JAVA0707LOrderSOOP04LunchOrderItem orderItem : orderItemList) {
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
                    paymentItem = new JAVA0707LOrderSOOP05LunchPaymentItem();
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
		showMainMenu();
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
		showMainMenu();
	}
	
	/*
	 * 프로그램 종료
	 */

}