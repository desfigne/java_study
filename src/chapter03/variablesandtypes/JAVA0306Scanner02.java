package chapter03.variablesandtypes; // 이 파일이 속한 패키지를 정의함

import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스를 import함

public class JAVA0306Scanner02 { // 클래스 선언

	public static void main(String[] args) { // 메인 메서드 시작 (프로그램의 진입점)
		
		System.out.println("***********************************************\n"); // 구분선 출력
		
		System.out.println("\t Welcome to Shopping Mall"); // 쇼핑몰 환영 문구 출력
		System.out.println("\t Welcome to Food Market\n"); // 마켓 환영 문구 출력 후 줄바꿈
		
		System.out.println("***********************************************\n"); // 구분선 출력
		
		System.out.println("\t 1. 상품보기 \t 2. 상품구입"); // 메뉴 항목 1번과 2번 출력
		System.out.println("\t 3. 영수증보기 \t 4. 종료\n"); // 메뉴 항목 3번과 4번 출력 후 줄바꿈
		
		System.out.println("***********************************************\n"); // 구분선 출력
		
		Scanner scan =  new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		System.out.print("메뉴를 선택해주세요. (숫자) > "); // 사용자에게 메뉴 번호 입력 요청 메시지 출력
		String number = scan.next(); // 사용자가 입력한 값을 문자열로 받아서 변수 number에 저장
		
		// 선택 메뉴 체크 확인
		
		System.out.println("선택한 메뉴 : " + number); // 사용자가 선택한 메뉴 번호를 출력
		
	}
}
