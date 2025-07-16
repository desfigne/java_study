package chapter07_class.C0714_vendingmachine_v01;

import java.util.Scanner;

public class V1401User {
	
	// Field
	String name;
	Scanner scan;
	
	// Constructor
//	public V01User() {this.name = "아무개";}
	public V1401User() {this("아무개");}
	public V1401User(String name) {
		this.name = name;
		scan = new Scanner(System.in);
	}
	
	// Method
	
	/*
	 * 동전 입력
	 */
	public int insertCoin() {
		int resultCoin = 0;
		System.out.print("[" + name + "] 동전입력 > ");
		if(scan.hasNextInt()) {
			
			// 동전 체크 : 100원, 500원만 입력 가능
			int coin = scan.nextInt();
			resultCoin = coin;
//			if(coinCheck(coin))  {
//				
//			}
		} else {
			System.out.println("올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
			insertCoin();
		}
		
		return resultCoin;
	}
	
	/* 
	 * 메뉴 선택
	 */
	public int selectMenu() { // 호출되는 객체가 다르니 명칭은 중복되도 상관없음
		int menu = 0;
		System.out.print("[" + name + "] 메뉴선택 > ");
		if(scan.hasNextInt()) {
			menu = scan.nextInt();
		} else {
			System.out.println("올바르지 않은 값, 다시 입력해주세요.");
			scan.next();
            selectMenu();
//			insertCoin(); // 복사 붙여넣기 하면서 기존 다른 메소드의 코드가 들어간 상태라 개인적으로 수정해서 윗줄로 교체함
		}
		
		return menu;
	}
	
}
