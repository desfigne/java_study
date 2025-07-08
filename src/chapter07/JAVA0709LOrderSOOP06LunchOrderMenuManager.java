package chapter07;

public class JAVA0709LOrderSOOP06LunchOrderMenuManager {
	
	// Field
//	String[] lunchMenuNames;
//	int[] lunchMenuPrices;
//	
//	// Constructor
//	public JAVA0709LOrderSOOP06LunchOrderMenuManager() {}
//	public JAVA0709LOrderSOOP06LunchOrderMenuManager(String[] lunchMenuNames, int[] lunchMenuPrices) {
//		this.lunchMenuNames = lunchMenuNames;
//		this.lunchMenuPrices = lunchMenuPrices;
//	}
	
	// Field
	JAVA0709LOrderSOOP01System mgmsystem;
	
	// Constructor
	public JAVA0709LOrderSOOP06LunchOrderMenuManager() {}
	public JAVA0709LOrderSOOP06LunchOrderMenuManager(JAVA0709LOrderSOOP01System system) {
		this.mgmsystem = system;
	}
	
	// Method
	/*
	 * 05. 런치 메뉴 생성
	 */
	public void createLunchMenu() {
	    for(int i = 0; i < mgmsystem.lunchMenuNames.length; i++ ) {
	    	// 아래 코드가 for문 안에 있을 경우에는 정상 출력, for문 밖에 있을 경우 중복 내용으로 처리됨
	    	// for문 바깥에 놓게 되면 객체를 하나를 그대로(주소값 동일) 사용하게 되고, for문 안에 배치하면 객체를 1개씩 새로 생성(주소값 다름)해서 사용
	    	// 생성은 안에서 진행해야 함 예) for문 밖에 선언은 > LunchMenu menu = null; for문 안에 선언은 > menu = new LunchMenu();
	    	JAVA0709LOrderSOOP03LunchMenu menu = new JAVA0709LOrderSOOP03LunchMenu();
	    	//
	    	menu.no = i + 1;
	    	menu.name = mgmsystem.lunchMenuNames[i];
	    	menu.price = mgmsystem.lunchMenuPrices[i];
	    	
	    	mgmsystem.lunchMenuList[i] = menu;
	    }
	}
    
    /*
     * 05. 02. 런치 메뉴 출력
     */
//    public void showLunchMenu() {
//    	int no = 1;
//    	System.out.println("******************************************");
//	    System.out.println("=> lunchMenuList");
//	    for (JAVA0709LOrderSOOP03LunchMenu menu2 : lunchMenuList) {
//	    	System.out.print(no + ".");
//	    	System.out.print(menu2.name + "\t");
//	    	System.out.print(menu2.price + "\n");
//	    	no++;
//	    	System.out.println("******************************************");
//	    }
//    }
    public void showLunchMenu() {
    	System.out.println("******************************************");
	    for (JAVA0709LOrderSOOP03LunchMenu menu : mgmsystem.lunchMenuList) {
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
	    
	    if(mgmsystem.scan.hasNextInt()) {
	    	lunchMenuCheck(mgmsystem.scan.nextInt());
	    } else {
	    	System.out.println("입력된 값이 바르지 않습니다, 다시 입력해주세요.");
	    	mgmsystem.scan.next(); // 잘못된 값을 받지 않으면 버퍼에만 머무름
	    	selectMainMenu();
	    }
	}
	
	/* 
	 * 01. 메인 메뉴 출력
	 */
	public void showMainMenu() {
		System.out.println("\n******************************************");
	    System.out.println("\t Welcome to [" + mgmsystem.title + "] Food Mart!!!");
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
	    
	    if(mgmsystem.scan.hasNextInt()) {
	    	mainMenuCheck(mgmsystem.scan.nextInt());
	    } else {
	    	System.out.println("입력된 값이 바르지 않습니다, 다시 입력해주세요.");
	    	mgmsystem.scan.next(); // 잘못된 값을 받지 않으면 버퍼에만 머무름
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
		case 2: mgmsystem.orderList(); break;
		case 3: mgmsystem.payment(); break;
		case 4: mgmsystem.paymentList(); break;
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
			mgmsystem.order(lunchMenu);
		} else {
			System.out.println("=> 런치 메뉴 준비중입니다, 다시 입력해주세요.");
			showLunchMenu();
		}
	}

}
