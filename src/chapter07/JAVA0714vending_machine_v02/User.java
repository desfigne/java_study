package chapter07.JAVA0714vending_machine_v02;

import java.util.Scanner;

public class User {
    // Field(필드)
    String name;      // 사용자 이름
    Scanner scan;     // 입력을 위한 스캐너 객체

    // Constructor(생성자)
    public User() {
        // 1. 기본값 "아무개"로 아래 생성자 호출
    	this("홍길동");
    }

    public User(String name) {
        // 1. 전달받은 이름으로 name 필드 초기화
    	this.name = name;
        // 2. scan 객체 생성
    	scan = new Scanner(System.in);
    }

    // Method(메소드)
    
    // 동전 입력 메소드
    public int insertCoin() {
    	// 1. 반환할 변수 선언 및 0으로 초기화
        int resultCoin = 0;
        
        // 2. 안내 메시지 출력
        System.out.print(name + "님의 동전입력 > ");
        
        // 3. 입력값이 정수인지 먼저 확인
        if(scan.hasNextInt()) {
        	
        	// 4. 정수라면 입력값 저장
            int coin = scan.nextInt();
            
            // 5. 입력값을 반환 변수에 저장
            resultCoin = coin;
            
        } else {
        	
        	// 6. 정수가 아니면 안내 메시지 출력
            System.out.println("올바르지 않은 입력값입니다, 다시 입력해주세요.");
            
            // 7. 잘못된 입력값 버리기
            scan.next();
            
            // 8. 재귀 호출로 다시 입력받기
            insertCoin();
        }
        
        // 9. 입력값 반환
        return resultCoin; 
    }



	// 메뉴 선택 메소드
	public int selectMenu() {
		// 1. 반환할 변수 선언 및 0으로 초기화
		int menu = 0;
	
		// 2. "[이름] 메뉴선택 > " 안내 메시지 출력
        System.out.print(name + "님의 메뉴선택 > ");
	
		// 3. 입력값이 정수인지 확인
		if (scan.hasNextInt()) {
			
			// 4. 정수면 입력값 저장
			menu = scan.nextInt();
	
		} else {
        	
        	// 6. 정수가 아니면 안내 메시지 출력
            System.out.println("올바르지 않은 메뉴값입니다, 다시 입력해주세요.");
            
            // 7. 잘못된 입력값 버리기
            scan.next();
            
            // 8. 재귀 호출로 다시 입력받기
            selectMenu();
	
		}
	
		// 6. 입력값 반환
		return menu;
	    }


    // getter 메소드
    public String getName() { return name; }
    public Scanner getScan() { return scan; }
}
