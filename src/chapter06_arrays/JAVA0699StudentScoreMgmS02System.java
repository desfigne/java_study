package chapter06_arrays;

import java.util.Scanner;

public class JAVA0699StudentScoreMgmS02System {

	Scanner scan = new Scanner(System.in);
	int menu;
	int count = 0;
	final int MAX = 100;
	JAVA0699StudentScoreMgmS03Student[] students = new JAVA0699StudentScoreMgmS03Student[MAX];

	public void run() {
		while (true) {
			showMenu();
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				registerStudent();
				break;
			case 2:
				listStudents();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				updateScore();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void showMenu() {
		System.out.println("===== 학생 성적 관리 시스템 =====");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 목록 조회");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 성적 수정");
		System.out.println("5. 학생 삭제");
		System.out.println("6. 종료");
		System.out.print("메뉴를 선택하세요: ");
	}

	// 1. 학생 등록
	public void registerStudent() {
		if (count >= MAX) {
			System.out.println("더 이상 학생을 등록할 수 없습니다.");
			return;
		}
		JAVA0699StudentScoreMgmS03Student s = new JAVA0699StudentScoreMgmS03Student();
		System.out.print("학번: ");
		s.studentId = scan.next();
		System.out.print("이름: ");
		s.name = scan.next();
		System.out.print("전공: ");
		s.major = scan.next();
		System.out.print("학년: ");
		s.grade = scan.nextInt();
		System.out.print("국어 점수: ");
		s.kor = scan.nextInt();
		System.out.print("영어 점수: ");
		s.eng = scan.nextInt();
		System.out.print("수학 점수: ");
		s.math = scan.nextInt();
		s.calcScore();
		students[count++] = s;
		System.out.println("학생 등록이 완료되었습니다.");
	}

	// 2. 학생 목록 조회
	public void listStudents() {
		if (count == 0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		System.out.println("학번\t이름\t전공\t학년\t국어\t영어\t수학\t총점\t평균\t등급");
		for (int i = 0; i < count; i++) {
			JAVA0699StudentScoreMgmS03Student s = students[i];
			System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s.studentId, s.name, s.major, s.grade,
					s.kor, s.eng, s.math, s.tot, s.avg, s.gradeLetter);
		}
	}

	// 3. 학생 성적 검색
	public void searchStudent() {
		System.out.print("검색할 학생의 학번을 입력하세요: ");
		String id = scan.next();
		boolean found = false;
		for (int i = 0; i < count; i++) {
			JAVA0699StudentScoreMgmS03Student s = students[i];
			if (s.studentId.equals(id)) {
				System.out.println("학번\t이름\t전공\t학년\t국어\t영어\t수학\t총점\t평균\t등급");
				System.out.printf("%s\t%s\t%s\t%d\t%d\t%d\t%d\t%d\t%.2f\t%s\n", s.studentId, s.name, s.major, s.grade,
						s.kor, s.eng, s.math, s.tot, s.avg, s.gradeLetter);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 학번의 학생이 없습니다.");
		}
	}

	// 4. 성적 수정
	public void updateScore() {
		System.out.print("성적을 수정할 학생의 학번을 입력하세요: ");
		String id = scan.next();
		boolean found = false;
		for (int i = 0; i < count; i++) {
			JAVA0699StudentScoreMgmS03Student s = students[i];
			if (s.studentId.equals(id)) {
				System.out.print("국어 점수: ");
				s.kor = scan.nextInt();
				System.out.print("영어 점수: ");
				s.eng = scan.nextInt();
				System.out.print("수학 점수: ");
				s.math = scan.nextInt();
				s.calcScore();
				System.out.println("성적이 수정되었습니다.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 학번의 학생이 없습니다.");
		}
	}

	// 5. 학생 삭제
	public void deleteStudent() {
		System.out.print("삭제할 학생의 학번을 입력하세요: ");
		String id = scan.next();
		boolean found = false;
		for (int i = 0; i < count; i++) {
			if (students[i].studentId.equals(id)) {
				// 뒤의 학생들을 앞으로 한 칸씩 이동
				for (int j = i; j < count - 1; j++) {
					students[j] = students[j + 1];
				}
				students[count - 1] = null;
				count--;
				System.out.println("학생이 삭제되었습니다.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("해당 학번의 학생이 없습니다.");
		}
	}
}
