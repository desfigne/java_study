package chapter07.java0714vending_machine_v02;

import chapter07.java0713commons.Menu;

public class VendingMachine {
	
    // Field
	
    // 1. 자판기 이름(title), 메뉴명 배열(nameList), 가격 배열(priceList)
	String title;
	String[] nameList = {"☕ 밀크커피", "☕ 아메리카노", "🍋 유자차 ", "🥛 초코우유"};
	int[] priceList = {300, 400, 300, 200};
	
    // 2. Menu[] menuList, Menu[] orderMenuList, int orderMenuCount
	Menu[] menuList;
	Menu[] orderMenuList;
	int orderMenuCount = 0;
	
    // 3. User user, int totalCoin, Menu orderMenu, int change
	User user;
	int totalCoin;
	Menu orderMenu;
	int change;
	
	static final int EXIT = 9;

	
	
    // Constructor
	
    // 1. 사용자(user)만 받는 생성자
    //    - this("기본이름", user)로 넘기기
	public VendingMachine(User user) {
		this("더조은자판기", user);
	}
	
    // 2. 자판기 이름(title), 사용자(user) 받는 생성자
    //    - 필드 초기화
    //    - menuCreate() 호출
    //    - menuShow() 호출
    //    - checkCoin() 호출
	public VendingMachine(String title, User user) {
		this.title = title;
		createMenuList();
		showMenuList();
		checkInsertCoin();
	}

	
	
    // Method

	// 메뉴 리스트 생성
	public void createMenuList() {
		
	    // 1. 메뉴 정보를 저장할 배열 menuList를 nameList의 길이만큼 생성
	    menuList = new Menu[nameList.length];

	    // 2. nameList의 길이만큼 반복 (각 메뉴 정보를 하나씩 처리)
	    for(int i = 0; i < nameList.length; i++) {

	        // 3. 메뉴 번호는 배열 인덱스에 1을 더해 1번부터 시작하도록 지정
	        int no = i + 1;

	        // 4. 현재 인덱스의 메뉴 이름을 nameList에서 꺼냄
	        String name = nameList[i];

	        // 5. 현재 인덱스의 메뉴 가격을 priceList에서 꺼냄
	        int price = priceList[i];

	        // 6. 번호, 이름, 가격을 이용해 Menu 객체 생성
	        Menu menu = new Menu(no, name, price);

	        // 7. 생성한 Menu 객체를 menuList 배열의 i번째 위치에 저장
	        menuList[i] = menu;
	    }
	}

	// 주문 가능한 메뉴 리스트 생성
	public void createOrderMenuList(int totalCoin) {
		
	    // 1. 주문 가능한 메뉴를 저장할 배열 orderMenuList를 menuList의 길이만큼 생성
		orderMenuList = new Menu[menuList.length];
		
	    // 2. orderMenuCount를 0으로 초기화 (이전 값이 남아있지 않게)
		orderMenuCount = 0;
		
	    // 3. menuList의 모든 메뉴를 처음부터 끝까지 하나씩 꺼내서 반복
		for(Menu menu : menuList) {
			
	        // 4. 각 메뉴의 가격이 투입 금액 이하인지 확인
			if(menu.getPrice() <= totalCoin) {
				
	            // 5. 조건을 만족하면 orderMenuList에 해당 메뉴를 저장
				orderMenuList[orderMenuCount] = menu;
				
	            // 6. 주문 가능한 메뉴 개수(orderMenuCount) 1 증가
				orderMenuCount++;
			}
		}
	}
	
	// 전체 메뉴 출력
	public void showMenuList() {
		
	    // 1. 자판기 이름 등 안내 메시지 출력
        System.out.println("==============================================");
		System.out.println("☕🍋🥛" + title + "Coffee Vending Machine");
        System.out.println("==============================================");
        
	    // 2. for문으로 menuList의 모든 메뉴(번호, 이름, 가격) 출력
		for(Menu menu : menuList) {
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%d", menu.getPrice()) + "원\n");
		}
        System.out.println("==============================================");
	}

	// 주문 가능한 메뉴 출력
	public void showMenuList(String msg) {
		
	    // 1. 자판기 이름, msg 등 안내 메시지 출력
        System.out.println("==============================================");
		System.out.println("☕🍋🥛" + title + "Coffee Vending Machine");
        System.out.println("==============================================");
		System.out.println("\t 주문이 가능한 메뉴 리스트입니다.");
        System.out.println("==============================================");
        
	    // 2. 주문 가능한 메뉴(orderMenuList) 개수만큼 반복
        for(int i = 0; i < orderMenuCount; i++) {
        	Menu menu = orderMenuList[i];
        	
    		// 3. 각 메뉴의 번호, 이름, 가격을 예쁘게 출력
			System.out.print(menu.getNo() + "\t");
			System.out.print(menu.getName() + "\t");
			System.out.print(String.format("%d", menu.getPrice()) + "원\n");
        }
        
	    // 4. 구분선 출력
        System.out.println("==============================================");
	}

	// 동전 입력 및 체크
	public void checkInsertCoin() {
		
	    // 1. 동전 투입 안내 메시지 출력
		System.out.print("=> 투입할 동전을 입력해주세요.");

	    // 2. 사용자로부터 동전 입력받기
		int coin = user.insertCoin();

	    // 3. 입력한 동전이 100원 또는 500원인지 확인
		if(coin == 100 || coin == 500) {

	        // 4. 총 투입 금액에 입력한 동전 금액을 누적
			totalCoin += coin;

	        // 5. 총 투입 금액 안내 메시지 출력
			System.out.println("투입된 동전 총합 : " + totalCoin);

	        // 6. 최소 메뉴 금액(200원)보다 적은지 확인
			if(totalCoin < 200) {
		
	            // 7. 최소 금액 부족 안내 메시지 출력
				System.out.println("금액이 부족합니다, 동전을 추가로 투입해주세요.");

	            // 8. 다시 동전 입력받기 (재귀 호출)
				checkInsertCoin();
				
			} else {
				
	            // 9. 메뉴 선택 또는 동전 추가 입력 여부 안내
				System.out.print("=> 메뉴 선택 (n) / 동전 추가 투입 (아무키)");

	            // 10. 사용자가 "n"을 입력하면 메뉴 선택 단계로 이동
				if(user.scan.next().equals("n")) {
		
	                // 11. 주문 가능한 메뉴 리스트 생성
					createOrderMenuList(totalCoin);

	                // 12. 주문 가능한 메뉴 리스트 출력
					showMenuList("주문 가능한 메뉴 리스트입니다.");

	                // 13. 메뉴 선택 단계로 이동
					selectMenu();
					
				} else {
					
					// 14. "n"이 아니면 다시 동전 입력받기
					checkInsertCoin();
				}
			}
			
		} else {
			
	        // 15. 사용 불가 동전 안내 메시지 출력
			System.out.println("100원 또는 500원만 투입이 가능합니다.");

	        // 17. 다시 동전 입력받기 (재귀 호출)
			checkInsertCoin();
		}
	}


	// 메뉴 선택
	public void selectMenu() {
	    // 1. 메뉴 선택 안내 메시지 출력
		System.out.println("=> 메뉴를 선택해 주세요.");
		
	    // 2. 취소 방법 안내 메시지 출력 (EXIT 번호 안내)
		System.out.println("=> 취소는 [" + VendingMachine.EXIT + "] 번을 입력해주세요.");
		
	    // 3. 사용자로부터 메뉴 번호 입력받기
		int menuNo = user.selectMenu();
		
	    // 4. 입력한 값이 EXIT(취소)가 아닌지 확인
		if(menuNo != VendingMachine.EXIT) {
			
	        // 5. 입력 번호가 주문 가능한 메뉴인지 확인
			if(menuCheck(menuNo)) {
				
	            // 6. 주문 가능한 메뉴라면 주문 처리 단계로 이동
				placeOrder(menuNo);
				
			// 7. 주문 불가(없는 번호)라면 안내 없이 다시 메뉴 선택 단계로 이동
			} else selectMenu();
			
		} else {
			
	        // 8. EXIT(취소) 입력 시 동전 반환 안내 메시지 출력
			System.out.println("************************************************");
			System.out.println("=> 동전을 반환하고, 프로그램을 종료합니다.");
			
	        // 9. 반환 동전 금액 안내 메시지 출력
			System.out.println("=> 반환 동전 : " + totalCoin);
			
	        // 10. 프로그램 종료
			System.exit(0);
		}
	}

	// 주문(선택한 메뉴 저장)
	public void placeOrder(int menuNo) {
		
	    // 1. 주문 가능한 메뉴 리스트(orderMenuList)에서 선택한 메뉴 번호(menuNo)와 같은 메뉴를 찾기 위해 반복
		for(Menu menu : orderMenuList) {
			
	        // 2. 배열에 저장된 메뉴가 null이 아닌지 확인 (null이면 더 이상 유효한 메뉴가 없음)
			if(menu != null) {
				
	            // 3. 메뉴 번호가 사용자가 선택한 번호와 같은지 비교 + 4. 같으면 orderMenu에 해당 메뉴 객체를 저장
				if(menu.getNo() == menuNo) orderMenu = menu;
		
			// 5. null을 만나면 반복문 종료(더 이상 유효한 메뉴 없음)
			} else break;

	    // 6. 주문 완료 안내 메시지 출력
		System.out.println("=> 주문 완료");
		
	    // 7. 결제 처리 단계로 이동
		processPayment();
		}
	}


	// 결제 진행
	public void processPayment() {
		
	    // 1. 주문한 메뉴(orderMenu)가 null이 아닌지 확인
		if(orderMenu != null) {
			
	        // 2. 주문한 메뉴의 가격을 가져옴
			int price = orderMenu.getPrice();
			
	        // 3. 주문한 메뉴 가격이 총 투입 금액 이하인지 확인
			if(price <= totalCoin) {
				
	            // 4. 결제 진행: 잔돈(change) 계산
				change = totalCoin - price;
				
				// 5. 결제 완료 안내 메시지 출력
				System.out.println("=> 결제 완료");
				System.out.println("=> 음료 제조중 ...");
				
				// 6. (주석) 사용한 객체 초기화: orderMenuList, orderMenu, orderMenuCount 등
				reset();
			}
		}
		
	    // 7. 결제 후 최종 처리(잔돈, 추가 주문 등) 단계로 이동
		finalCheck();
	}


	// 종료 후 객체 초기화
	public void reset() {
		
	    // 1. 총 투입 금액을 0으로 초기화
		totalCoin = 0;

	    // 2. 주문 가능한 메뉴 개수를 0으로 초기화
		orderMenuCount = 0;

	    // 3. 주문 가능한 메뉴 리스트 배열을 null로 초기화
		orderMenuList = null;
		
		// 4. 주문한 메뉴 객체를 null로 초기화
		orderMenu = null;
	}


	// 종료(파이널 체크)
	public void finalCheck() {
	    // 1. 메뉴 리스트에서 가장 저렴한 메뉴의 가격을 구함 (예: 마지막 메뉴의 가격 사용)
		int price = menuList[menuList.length-1].getPrice();
		
	    // 2. 잔돈이 최소 메뉴 가격 이상인지 확인
		if(change >= price) {
			
	        // 3. 잔돈을 총 투입 금액으로 다시 설정
			totalCoin = change;

	        // 4. 잔돈 안내 메시지 출력
			System.out.println("=> 잔돈 : " + change);

	        // 5. 주문 가능한 메뉴 리스트를 다시 생성
			createOrderMenuList(totalCoin);

	        // 6. 주문 가능한 메뉴 리스트 출력
			showMenuList("주문 가능 메뉴 리스트");

	        // 7. 추가 주문을 위해 메뉴 선택 단계로 이동
			selectMenu();
		
		} else {
			
	        // 8. 결제 내역(메뉴명, 가격, 잔돈) 출력
			System.out.println("=> 잔돈 : " + change);

	        // 9. 이용해주셔서 감사합니다 메시지 출력
			System.out.println("=> 이용해주셔서 감사합니다.");
		}
	}


	// 주문 가능한 메뉴인지 체크
	public boolean menuCheck(int menuNo) {
		
	    // 1. 결과를 저장할 변수 result를 false로 초기화 (기본값: 메뉴 없음)
		boolean result = false;

	    // 2. 주문 가능한 메뉴 리스트(orderMenuList)를 orderMenuCount만큼 반복
		for(int i = 0; i < orderMenuCount; i++) {
		
	        // 3. 현재 인덱스의 메뉴 객체를 꺼냄
			Menu menu = orderMenuList[i];

	        // 4. 메뉴 번호가 입력받은 menuNo와 같은지 비교 = 5. 같으면 result를 true로 변경 (메뉴 있음)
			if(menu.getNo() == menuNo) result = true;
		}

	    // 6. 최종 결과 반환 (true: 있음, false: 없음)
	    return result;
	}

}
