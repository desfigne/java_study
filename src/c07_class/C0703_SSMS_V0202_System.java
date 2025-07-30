package c07_class;

import java.util.Scanner;

/* 
 * 학생 3명의 점수를 입력 받는다.
 * 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 * 
 */

public class C0703_SSMS_V0202_System {

	// Field : 맴버변수, 전역변수
	String admin;
	C0703_SSMS_V0201_Student student;

	Scanner scan = new Scanner(System.in);
//	JAVA0703ScoreMgmSystem01Student[] sList = new JAVA0703ScoreMgmSystem01Student[10];
	
	// Constructor
	public C0703_SSMS_V0202_System() {}
	
	// Method
	public void insert() {
		System.out.println("=============================================");
		System.out.println("==================== 등록 ====================");
		System.out.println("=============================================");
		student = new C0703_SSMS_V0201_Student();
		
		System.out.print("학생명 입력해주세요. > ");
		student.name = scan.next();
		
		System.out.print("국어 점수를 입력해주세요. > ");
		student.kor = scan.nextInt();
		
		System.out.print("영어 점수를 입력해주세요. > ");
		student.eng = scan.nextInt();
		
		System.out.print("수학 점수를 입력해주세요. > ");
		student.math = scan.nextInt();

		System.out.println("=> 등록이 완료되었습니다. <=");
	}
	
	public void show() {
		System.out.println("=============================================");
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
		System.out.println("수정");
	}
	
	public void remove() {
		System.out.println("제거");
	}
	
	public void search() {
		System.out.println("검색");
	}

}
