package c07_class.C0714_vendingmachine_v01;

import c07_class.C0713_commons.Menu;

public class C071402_VendingMachine {
	
	String[] nameList = {"☕ 밀크커피", "☕ 아메리카노", "🍋 유자차 ", "🥛 초코우유"};
	int[] priceList = {300, 400, 300, 200};
	Menu[] menuList; // user가 주문가능한 메뉴 = menuList X
	Menu[] orderMenuList;
	int orderMenuCount = 0;
	
	String title; // 자판기 회사명
	C071401_User user; // 자판기 사용자 등으로 주석으로 표시
	int totalCoin;
	Menu orderMenu;
	int change;
	
	static final int EXIT = 9; // 클래스명.상수명
	
	public C071402_VendingMachine(C071401_User user) {
		this("막심", user);
	}
	
	public C071402_VendingMachine(String title, C071401_User user) { // 오버로딩될 경우 동작
		this.title = title;
		this.user = user;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}
	
	/*
	 * 총 투입 금액에 맞춘 메뉴 출력
	 */
	public void showMenuList(String msg) {
		System.out.println("======================================");
		System.out.println("☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("======================================");
		System.out.println("\t" + msg);
		System.out.println("======================================");
//		for(Menu menu : orderMenuList) {
		for(int i = 0; i < orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("======================================");
	}

//	public void showMenuList(int totalCoin) {
//		System.out.println("======================================");
//		System.out.println("☕🍵🥤 " + title + " Coffee Machine");
//		System.out.println("======================================");
//		for(Menu menu : menuList) {
//			if(menu.getPrice() <= totalCoin) {
//				System.out.print(menu.getNo() + "\t");
//				System.out.print(menu.getName() + "\t");
//				System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
//			}
//		}
//		System.out.println("======================================");
//	}
	
	/*
	 * 전체 메뉴 출력
	 */
	public void showMenuList() {
		System.out.println("======================================");
		System.out.println("☕🍵🥤 " + title + " Coffee Machine");
		System.out.println("======================================");
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%,d", menu.getPrice()) + "원\n");
		}
		System.out.println("======================================");
	}
	
	/*
	 * 메뉴 리스트 생성
	 */
	public void createMenuList() {
		menuList = new Menu[nameList.length];
		for(int i=0; i<nameList.length; i++) {
			int no = i + 1;
			String name = nameList[i];
			int price = priceList[i];
			
			Menu menu = new Menu(no, name, price);
			menuList[i] = menu;
		}
	}
	
//	public boolean coinCheck(int coin) {
//		boolean result = false;
//		if(coin == 100 || coin == 500) {
//			result = true;
//		}
//		return result;
//	}
	
	/* 
	 * 주문 가능한 메뉴 리스트 생성
	 */
	public void createOrderMenuList(int totalCoin) {
		orderMenuList = new Menu[menuList.length];
		
		// orderMenuCount 변수를 이용하여 향상된 for문 사용시
		for(Menu menu : menuList) {
			if(menu.getPrice() <= totalCoin) {
				orderMenuList[orderMenuCount] = menu;
				orderMenuCount++;
			}
		}
		
		// 일반 for문 사용시
//		for(int i = 0; i < menuList.length; i++) {
//			Menu menu = menuList[i];
////			Menu omenu = orderMenuList[i];
//			if(menu.getPrice() <= totalCoin) {
////				omenu = menu;
//				orderMenuList[i] = menu;
//			}
//		}
	}
	
	/*
	 * 입력되는 동전 체크
	 */
	public void checkInsertCoin() {
		System.out.println("=> 동전을 투입해주세요.");
		int coin = user.insertCoin();
		
		if(coin == 100 || coin == 500) { // 사용 가능한 동전을 체크
			totalCoin += coin;
			System.out.println("총 투입금액 : " + totalCoin);
			
			// 메뉴 선택의 최소 금액을 체크
//			if(!(totalCoin < 200)) { // 반대로 구성할 경우
			if(totalCoin < 200) {
				System.out.println("=> 최소 금액이 부족합니다.");
				checkInsertCoin();
			} else {
				// 메뉴 선택 여부 체크
				System.out.print("=> 메뉴 선택(n), 동전투입계속(아무키) > ");
				if(user.scan.next().equals("n")) {
					createOrderMenuList(totalCoin);
					showMenuList("주문 가능 메뉴 리스트");
					selectMenu();
				} else checkInsertCoin();
			}
		} else {
			System.out.println("=> 동전은 100원, 500원만 사용 가능합니다.");
			System.out.println("=> 동전은 반환됩니다. 동전을 다시 투입해주세요.");
			checkInsertCoin();
		}
	}
	
	/*
	 * 메뉴 체크
	 */
	public boolean menuCheck(int menuNo) {
		boolean result = false;
		
		for(int i = 0; i < orderMenuCount; i++) {
			Menu menu = orderMenuList[i];
			if(menu.getNo() == menuNo) result = true;
		}
		
		return result;
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() { // 정확한 메뉴 선택
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("=> 취소는 [" + C071402_VendingMachine.EXIT + "]번을 입력해주세요.");
		int menuNo = user.selectMenu();
		if(menuNo != C071402_VendingMachine.EXIT) {
			if(menuCheck(menuNo)) {
				placeOrder(menuNo);
			} else {
				selectMenu();
			}
		} else {
			System.out.println("동전을 반환하고 프로그램을 종료합니다.");
			System.out.println("반환 동전 : " +  totalCoin);
			System.exit(0);
		}
//		if(menuCheck(user.selectMenu())) {
//		if(menuCheck(menuNo)) {
//			// 다음단계 - 주문 결제 남은 상태
//			placeOrder(menuNo);
//		} else {
//			selectMenu();
//		}
//		Menu orderMenu = null;
//		
////		System.out.println("no = " + orderMenu.getNo());
////		System.out.println("name = " + orderMenu.getName());
////		System.out.println("getPrice = " + orderMenu.getPrice());
//		
//		if(orderMenu == null) {
//			selectMenu();
//		} else {
//			System.out.println("다음 단계");
//		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menuNo) {
		// 주문 가능한 메뉴 리스트에서 선택한 menuNo를 비교하여 메뉴 주소를 orderMenu에 대입
		for(Menu menu : orderMenuList) {
			if(menu != null) {
				if(menu.getNo() == menuNo) orderMenu = menu;
			} else break;
		}
		System.out.println("=> 주문이 완료되었습니다.");
		processPayment();
		
//		for(int i = 0; i < orderMenuCount; i++) {
//			Menu menu = orderMenuList[i];
//			if(menu.getNo() == menuNo) {
//				orderMenu = menu;
//				processPatment();
//				return;
//			}
//		}
	}
	
	/*
	 * 결제 진행
	 */
	public void processPayment() {
		if(orderMenu != null) {
			int price = orderMenu.getPrice();
			if(price <= totalCoin) {
				// 결제진행
				change = totalCoin - price;
			}
			System.out.println("=> 결제가 완료되었습니다.");
//			if(orderMenu.getPrice() <= totalCoin) {
//				// 결제진행
//				change = totalCoin - orderMenu.getPrice();
//			}
			// 사용한 객체 초기화 => orderMenuList, orderMenu, totalCount
		}
		finalCheck();
		reset();
	}
	
	/* 
	 * 종료 후 객체 초기화
	 */
	public void reset() {
		totalCoin = 0;
		orderMenu = null;
		orderMenuCount = 0;
		orderMenuList = null;
	}
	
	/*
	 * 종료
	 */
	public void finalCheck() {
		// 잔돈이 최소 주문금액보다 크면 계속 주문
		int price = menuList[menuList.length-1].getPrice();
//		if(change >= menuList[menuList.length-1].getPrice()) { // 너무 길면 지역변수로 전환처리
		if(change >= price) { // 너무 길면 지역변수로 전환처리
			totalCoin = change;
			System.out.print("=> 잔돈 : " + change);

			createOrderMenuList(totalCoin);
			showMenuList("주문 가능 메뉴 리스트");
			selectMenu();
		} else {
			System.out.println("=> 결제 내역");
			System.out.print("=> 메뉴명 : " + orderMenu.getName() + ", ");
			System.out.print("가격 : " + orderMenu.getPrice() + "\n");
			System.out.print("=> 잔돈 : " + change);
			System.out.println("\n=> 이용해주셔서 감사합니다.");
		}
	}

}