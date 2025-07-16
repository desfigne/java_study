package chapter07_class.java0712drink;

import java.util.Scanner;

public class D04OrderSystem {
	
	// Field
	String title;
	Scanner scan = new Scanner(System.in);
	String[] names = {"☕ 아메리카노", "🍵 바닐라 라떼", "🥤 딸기 쉐이크"};
	int[] price = {2800, 3500, 4000};
	D01Menu[] menuList = new D01Menu[names.length];
	D02Order order;
	D03Payment payment;
	
	// Constructor
	public D04OrderSystem() {
		this("Mega");
	}
	
	public D04OrderSystem(String title) {
		this.title = title;
		init();
	}
	
	// Method
	public void init() { // 02.
		payment = new D03Payment();
		createMenuList();
		showMenu();
		selectMenu();
	}
	
	/*
	 * 메뉴 선택
	 */
	public void selectMenu() { // 05.
		System.out.print("메뉴 선택(슷자) > ");
		if(scan.hasNextInt()) {
			int menu = scan.nextInt();
			if(1 <= menu && menu <= 3) {
				placeOrder(menu);  // 주문을 진행하는 메소드로 이동시킴
			} else {
				System.out.println("=> 메뉴 준비중입니다.");
	            selectMenu();
			}
		} else {
			System.out.println("=> 입력값이 올바르지 않습니다, 다시 입력해주세요.");
			scan.next(); // 이부분 없으면 에러 발생, 잘못된 값을 버리는 처리
			selectMenu();
		}
	}
	
	/*
	 * 주문
	 */
	public void placeOrder(int menu) { // 06.
		// 번호에 맞는 메뉴를 메뉴리스트에서 검색한다. 검색한 메뉴를 Order 생성자에 매개변수로 입력
		order = new D02Order(searchMenu(menu));
		if(order.orderMenu != null) order.getInfo();
		System.out.println("=> 주문 완료");
		
		processPayment();
	}
	
	/*
	 * 결제
	 */
	public void processPayment() { // 07.
		System.out.print("결제 금액 > ");
		if(scan.hasNextInt()) {
			payment.setAmount(scan.nextInt());
			System.out.println("=> 총 입금 금액 : " + payment.getAmount());
			if(payment.getPayment(order.orderMenu.price)) {
				// 결제 완료
				System.out.println("=> 결제 완료, 결제 후 잔액 : " + payment.getChange() + "원");
				showMenu();
				selectMenu();
			} else {
				// 금액 부족
				System.out.println("=> 결제 실패, 금액이 부족합니다, 다시 입력해주세요.");
				processPayment();
			}
		} else {
			System.out.println("=> 입력값이 올바르지 않습니다, 다시 입력해주세요.");
			scan.next();
			processPayment();
		}
	}
	
	public D01Menu searchMenu(int menuNo) {  // 04.
		D01Menu menu = null;
		
		for(D01Menu m : menuList) { // menuList[0] --> m --> menu(아메리카노);
			if(m.no == menuNo) { // String일 경우 이퀄스 사용
				menu = m;
				break;
			}
		}
		
		return menu; // menu(아메리카노)를 가르키는 주소값이 남음
	}
	
	public void showMenu() { // 03.
		System.out.println("===============================");
		System.out.println("☕🍵🥤 " + title + " 메뉴판");
		System.out.println("===============================");
		for(D01Menu menu : menuList) {
			System.out.print(menu.no + "\t");
			System.out.print(menu.name + "\t");
			System.out.print(String.format("%,d",  menu.price) + "원\n");
		}
		System.out.println("===============================");
	}

	public void createMenuList() { // 01.
		for(int i=0; i<names.length; i++) {
			D01Menu menu = new D01Menu((i+1), names[i], price[i]);
			menuList[i] = menu; // 이 줄 안넣을 경우 menu에 null 값이 표시됨
		}
	}
	

}
