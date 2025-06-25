package chapter03;

import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		
		System.out.println("***********************************************\n");
		System.out.println("\t Welcome to Shopping Mall");
		System.out.println("\t Welcome to Food Market\n");
		System.out.println("***********************************************\n");
		System.out.println("\t 1. 상품보기 \t 2. 상품구입");
		System.out.println("\t 3. 영수증보기 \t 4. 종료\n");
		System.out.println("***********************************************\n");
		Scanner scan =  new Scanner(System.in);
		System.out.print("메뉴를 선택해주세요. (숫자) > ");
		String number = scan.next();
		
		// 선택 메뉴 체크 확인
		
		System.out.println("선택한 메뉴 : " + number);
		
	}

}
