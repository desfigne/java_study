package chapter07;

import java.util.Scanner;

/* 
 * 학생 3명의 점수를 입력 받는다.
 * 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 * 
 */

public class JAVA0707ScoreMgmSystem02System {

	// Field : 맴버변수, 전역변수
	String admin;
	JAVA0703ScoreMgmSystem01Student student;

	Scanner scan = new Scanner(System.in);
	JAVA0703ScoreMgmSystem01Student[] sList = new JAVA0703ScoreMgmSystem01Student[10];
	int count = 0;
	
	// Constructor
	
	// Method
	/*
	 * 메뉴 선택
	 */
	public void showTitle() {
		
	}
	
	public void showMenu() {
		System.out.println("=============================================");
		System.out.println("====--- 더조은 고등학교 1-1 성적관리 프로그램 ---====");
		System.out.println("=============================================");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 리스트 출력");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 학생 성적 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.println("=============================================");
		
        System.out.print("메뉴선택 (숫자) > ");
//        int menu = scan.nextInt();
//        choiceMenu(menu);
        menuCheck(scan.nextInt());
	}
	/*
	 * 선택한 메뉴에 따라 기능별 메소드 호출
	 */
	
	public void menuCheck(int menu) {
        switch (menu) {
        case 1: insert(); showMenu(); break;
        case 2: showList(); showMenu(); break;
        case 3: search(); showMenu(); break;
        case 4: update(); showMenu(); break;
        case 5: remove(); showMenu(); break;
        case 9: System.out.println("-- 성적관리 시스템 종료 --");
                System.exit(0);
        default: System.out.println("-- 메뉴 준비중 --");
        		 showMenu();
        }
		
	}
	
	public void insert() {
		System.out.println("\n=============================================");
		System.out.println("==================== 등록 ====================");
		System.out.println("=============================================");
		sList[count] = new JAVA0703ScoreMgmSystem01Student();
		
		System.out.print("학생명 입력해주세요. > ");
		sList[count].name = scan.next();
		
		System.out.print("국어 점수를 입력해주세요. > ");
		sList[count].kor = scan.nextInt();
		
		System.out.print("영어 점수를 입력해주세요. > ");
		sList[count].eng = scan.nextInt();
		
		System.out.print("수학 점수를 입력해주세요. > ");
		sList[count].math = scan.nextInt();

		count++;
		System.out.println("=> 등록이 완료되었습니다. <=");
		
		System.out.print("계속 등록하시겠습니까? (예:아무키 / 아니오:n)");
		if(scan.next().equals("n")) {
			showMenu();
		} else {
			insert();
		}
	}
	
	public void showList() {
		System.out.println("\n=============================================");
		System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=============================================");
		System.out.print(student.name + "\t");
		System.out.print(student.kor + "\t");
		System.out.print(student.eng + "\t");
		System.out.print(student.math + "\t");
		System.out.print(student.getTot() + "\t");
		System.out.print(student.getAvg() + "\n");
		System.out.println("=============================================");
	}
	
	public void update() {
		System.out.println("\n=============================================");
		System.out.println("==================== 수정 ====================");
		System.out.println("=============================================");
		student = new JAVA0703ScoreMgmSystem01Student();
		
	}
	
	public void remove() {
		System.out.println("제거");
	}
	
	public void search() {
		System.out.println("검색");
	}

}
