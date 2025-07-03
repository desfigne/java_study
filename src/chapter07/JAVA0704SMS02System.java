package chapter07;

import java.util.Scanner;

/* 
 * 학생 3명의 점수를 입력 받는다.
 * 한 명 입력 후 계속 입력 여부를 메시지로 출력 후 입력 받는다.
 * 
 */

public class JAVA0704SMS02System {

	// Field : 맴버변수, 전역변수
	String admin;
	JAVA0704SMS01Student student;

	Scanner scan = new Scanner(System.in);
	JAVA0704SMS01Student[] sList = new JAVA0704SMS01Student[3];
	
	// Constructor
	public JAVA0704SMS02System() {}
	
	// Method
	public void insert() {
		/*
		 * 3명을 입력 받아야 하니 입력부터 등록 완료까지를 한 묶음으로 최대 3번까지 받도록 처리
		 * 그렇다면 3명의 정보를 어떻게 누적시킬 것인가? 카운트 ++ 처리로 반복시키고, 크기는 sList의 3자리보다 작거나 같을때까지, 그리고 아닐 경우 등록 최대 인원 3명에 도달하여 더이상 진행이 불가합니다. 라는 안내로 빠져나가게.
		 * 그렇다면 반복문은 무엇을 사용해야 하는가? 회수가 정해져 있기 때문에 for문을 사용
		 * 그리고 3명의 정보를 순서대로 어떻게 기입시킬 것인가? 2차 배열로 sList라는 배열에 3명이라는 행 3칸(인원수)을 만들고, 뒤에 열을 5칸(과목수3+계산수2)으로 구성
		 * 그렇다면 학생 배열에 학생 이름은 어떻게 입력된 값을 받을 것인가? student 변수에 [][] 2칸 선언
		 * 그리고 학생 배열에 맞춰서 학생 점수 3칸을 어떻게 입력된 값으로 받을 것인가?
		 * 최우선 순위, 입력값을 어떻게 누적값으로 전환시키는가?
		 * 
		 */
		 
		System.out.println("=============================================");
		System.out.println("==================== 등록 ====================");
		System.out.println("=============================================");
		student = new JAVA0704SMS01Student();
		
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
